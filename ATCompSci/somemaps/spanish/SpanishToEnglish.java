package spanish;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class SpanishToEnglish
{
	private Map<String,String> pairs;

	public SpanishToEnglish() {
		pairs = new TreeMap<String, String>();
	}
	
	public SpanishToEnglish(File f) throws IOException {
		pairs = new TreeMap<String, String>();
		Scanner add = new Scanner(f);
		int c = Integer.parseInt(add.nextLine());
		
		for(int i = 0; i < c; i++)
			putEntry(add.nextLine().trim());
		
		add.close();
	}

	public void putEntry(String entry) {
		String[] list = entry.split(" ");
		pairs.put(list[0], list[1]);
	}

	public String translate(String sent) {
		Scanner chop = new Scanner(sent);
		String output = "";
		while(chop.hasNext())
			output += pairs.get(chop.next()) + " ";

		chop.close();
		return output;
	}

	public String toString() {
		return pairs.toString().replaceAll("\\,","\n");
	}
}