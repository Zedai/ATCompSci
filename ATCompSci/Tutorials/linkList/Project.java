package linkList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Project {
	public static void main(String[] args){
		LinkedList<String> staff = new LinkedList<String>();
		staff.add("Bravo");
		staff.add("Charlie");
		staff.add("Foxtrot");
		staff.add("Tango");
		staff.add("Whiskey");
		
		System.out.println("Original List: " + staff);
		System.out.println("\nReverse");
		reverse(staff);
		System.out.println("\nDuplicate");
		duplicate(staff);
		System.out.println("\nRepeat");
		repeat(staff);
		System.out.println("\nDelete (Foxtrot)");
		delete(staff, "Foxtrot");
		System.out.println(staff);
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("\nString to Enter: ");
		add(staff, keyboard.nextLine());
		System.out.println(staff);
		keyboard.close();
	}
	
	public static void reverse(LinkedList<String> staff){
		ListIterator<String> iter = staff.listIterator();
		
		int c = 0;
		while(iter.hasNext()){
			c++;
			iter.next();
		}

		for(int i = c; i > 0; i--)
			System.out.println(iter.previous());
	}
	
	public static void duplicate(LinkedList<String> staff){
		ListIterator<String> iter = staff.listIterator();
		while(iter.hasNext()){
			String print = iter.next();
			System.out.println(print + "\n" + print);
		}
	} 
	
	public static void repeat(LinkedList<String> staff){
		String once = "";
		ListIterator<String> iter = staff.listIterator();
		
		while(iter.hasNext())
			once += iter.next() + "\n";
		
		System.out.println(once + once);
	}
	
	public static void delete(LinkedList<String> staff, String searchFor){
		ListIterator<String> iter = staff.listIterator();
		
		while(iter.hasNext())
			if(iter.next().equalsIgnoreCase(searchFor))
				iter.remove();
	}
	
	public static void add(LinkedList<String> staff, String toAdd){
		ListIterator<String> iter = staff.listIterator();
		
		while(iter.hasNext())
			if(iter.next().compareToIgnoreCase(toAdd) > 0){
				iter.previous();
				iter.add(toAdd);
				return;
			}
		
		staff.addLast(toAdd);
	}
}