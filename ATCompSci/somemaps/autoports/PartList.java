package autoports;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Scanner;

public class PartList {
	private TreeMap<Part, Integer> partsMap;

	public PartList(String fileName) throws FileNotFoundException {
		Scanner file = new Scanner(new File(fileName));
		partsMap = new TreeMap<Part, Integer>();
		
		while(file.hasNextLine()){
			Part part = new Part(file.nextLine());
			if(partsMap.containsKey(part))
				partsMap.put(part, partsMap.get(part) + 1);
			else
				partsMap.put(part, 1);
		}
		
		file.close();
	}

	public String toString() {
		String output = "";
		for(Entry<Part, Integer> x : partsMap.entrySet())
			output += x.getKey() + " \t||=>   " + x.getValue() + "\n";
		return output;
	}
}