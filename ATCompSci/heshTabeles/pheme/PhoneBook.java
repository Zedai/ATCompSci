package pheme;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class PhoneBook {
	int numSlots;
	LinkedList<ArrayList<PhoneEntry>> phoneBook;
	
	public PhoneBook(){
		this(10);
	}
	
	public PhoneBook(int numSlots){
		this.numSlots = numSlots;
		phoneBook = new LinkedList<ArrayList<PhoneEntry>>();
		for(int i = 0; i < numSlots; i++)
			phoneBook.add(i, new ArrayList<PhoneEntry>());
	}
	
	public void add(PhoneEntry p){
		int code = p.hashCode() % numSlots;;
		phoneBook.get(code).add(p);
	}
	
	public void display(){
		for(int i = 0; i < numSlots; i++)
			for(PhoneEntry p : phoneBook.get(i))
				System.out.println(p);
	}
	
	public void displayLexicographical(){
		ArrayList<PhoneEntry> list = new ArrayList<PhoneEntry>();
		for(int i = 0; i < numSlots; i++)
			for(PhoneEntry p : phoneBook.get(i))
				list.add(p);
		
		Collections.sort(list);
		for(PhoneEntry e : list)
			System.out.println(e);
	}
	
	public int getCapacity(){
		return numSlots;
	}
	
	public int getSize(){
		int count = 0;
		for(int i = 0; i < numSlots; i++)
			count += phoneBook.get(i).size();
		
		return count;
	}
	
	public void load(){
		try {
			Scanner in = new Scanner(new File("H:\\workspace\\ATCompSci\\heshTabeles\\pheme\\phone.txt"));
			while(in.hasNextLine())
				add(new PhoneEntry(in.next(), in.next()));
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int getNumberOfNulls(){
		int count = 0;
		for(int i = 0; i < numSlots; i++)
			if(phoneBook.get(i).size() == 0)
				count++;
		
		return count;
	}
	
	public int getLongestList(){
		int length = 0;
		for(int i = 0; i < numSlots; i++)
			if(phoneBook.get(i).size() > length)
				length = phoneBook.get(i).size();
		
		return length;
	}
	
	public String lookup(String lookfor){
		if(getEntry(lookfor) == null)
			return null;
		
		return getEntry(lookfor).getNumber();
	}
	
	private PhoneEntry getEntry(String lookfor){
		int hash = 0;
		for(char s : lookfor.toCharArray())
			hash += s;
		
		hash = hash % numSlots;
		
		for(int i = 0; i < phoneBook.get(hash).size(); i++)
			if(phoneBook.get(hash).get(i).getName().equals(lookfor))
				return phoneBook.get(hash).get(i);
		
		return null;
	}
	
	public boolean changeNumber(String lookfor, String newNumb){
		if(getEntry(lookfor) == null)
			return false;
		
		getEntry(lookfor).changeNum(newNumb);
		return true;
	}
}