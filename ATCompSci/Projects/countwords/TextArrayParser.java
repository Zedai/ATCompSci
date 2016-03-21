package countwords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class TextArrayParser {
	File file;
	String text = "";
	
	public TextArrayParser(File f){
		file = f;
		read();
		removePunctuation();
	}
	
	public void read(){
		try{
			Scanner reader = new Scanner(file);
				while(reader.hasNextLine())
					text += reader.nextLine() + " ";
			reader.close();
		}catch(FileNotFoundException e){
			System.out.println("File not found");
			e.printStackTrace();
		}
	}
	
	public void removePunctuation(){
		String[] remove = {"\'", "!", "\"", ":", ";", "\\?"};

		text = text.toLowerCase();
		text = text.replaceAll("  ", " ");		
		text = text.replaceAll(" - ", " ");
		text = text.replaceAll(",", " ");
		text = text.replaceAll("\\.", " ");
		
		for(int i = 0; i < remove.length; i++)
			text = text.replaceAll(remove[i], "");
		
		text = text.trim();
		text = text + " ";
//		System.out.println(text);
	}
	
	public ArrayList<Entry> arrayParse(){
		HashSet<String> billy = new HashSet<String>();
		ArrayList<Entry> ret = new ArrayList<Entry>(); 
		String temp = text;
		
		while(temp.length() != 1){
			try{
				if(billy.add(temp.substring(0, temp.indexOf(" ")).trim()))
					ret.add(new Entry(temp.substring(0, temp.indexOf(" ")).trim()));
				else
					for(Entry e : ret)
						if(e.getName().equalsIgnoreCase(temp.substring(0, temp.indexOf(" ")).trim()))
							e.add();
			} catch(StringIndexOutOfBoundsException e){	
				return ret;
			}

			temp = temp.substring(temp.indexOf(" ") + 1);
		}
		
		return ret;
	}
}