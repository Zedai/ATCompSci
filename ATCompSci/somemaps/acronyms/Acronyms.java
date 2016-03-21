package acronyms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Acronyms
{
	private Map<String,String> acronymTable;

	public Acronyms(File f) throws FileNotFoundException
	{
		Scanner in = new Scanner(f);
		acronymTable = new TreeMap<String, String>();
		int cap = Integer.parseInt(in.nextLine());
		
		for(int i = 0; i < cap; i++)
			putEntry(in.nextLine());
		in.close();
	}

	public void putEntry(String entry)
	{
		entry = entry.replace(" - ", " ").trim();
		acronymTable.put(entry.substring(0, entry.indexOf(" ")), entry.substring(entry.indexOf(" ") + 1));
	}

	public String convert(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output ="";

		while(chop.hasNext()){
			String n = chop.next(), s = "";
			while(n.endsWith(".") || n.endsWith(",")){
				s += n.charAt(n.length() - 1);
				n = n.substring(0, n.length() - 1);
			}
			s += " ";
			
			if(acronymTable.containsKey(n))
				output += acronymTable.get(n);
			else 
				output += n;

			output += s;
		}
		chop.close();
		return output;
	}

	public String toString()
	{
		return "";
	}
}