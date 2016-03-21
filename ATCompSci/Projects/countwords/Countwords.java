package countwords;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Countwords {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		TextArrayParser fred = new TextArrayParser(new File("H:\\workspace\\ATCompSci\\Projects\\countwords\\dream.txt"));

		ArrayList<Entry> arr = fred.arrayParse();
		
		for(int i = 0; i < arr.size(); i++)
			if(arr.get(i).getName().equalsIgnoreCase(""))
				arr.remove(i);
			
		int total = 0;
		for(Entry e : arr)
			total += e.getFreq();
		
		Collections.sort(arr);
		System.out.println("Unique Words: " + arr.size() + "\nTotal Words: "  + total);
		System.out.println("Top 30 Words:");
		System.out.println("Word  Frequency");
		for(int i = 0; i < 30; i++)
			System.out.println(arr.get(i));
		
	}

}
