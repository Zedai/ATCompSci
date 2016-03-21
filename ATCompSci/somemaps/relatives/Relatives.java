package relatives;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Relatives
{
	private Map<String,Set<String>> map;

	public Relatives()
	{
		map = new TreeMap<String, Set<String>>();
	}

	public void setPersonRelative(String line)
	{
		String[] personRelative = line.split(" ");

		if(map.containsKey(personRelative[0]))
			map.get(personRelative[0]).add(personRelative[1]);
		else{
			Set<String> s = new TreeSet<String>();
			s.add(personRelative[1]);
			map.put(personRelative[0], s);
		}
	}


	public String getRelatives(String person)
	{
		return person + " is related to " + map.get(person).toString();
	}


	public String toString()
	{
		String output="";
		Set<Entry<String, Set<String>>> s = map.entrySet();
		
		for(Entry<String, Set<String>> x : s)
			output += x.getKey() + " is related to " + x.getValue().toString() + "\n";

		return output;
	}
}