package oddEven;

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

public class OddEvenSets
{
	private Set<Integer> odds = new TreeSet<Integer>();
	private Set<Integer> evens = new TreeSet<Integer>();

	public OddEvenSets()
	{
	}

	public OddEvenSets(String line)
	{
		Set<String> set = new TreeSet<String>(Arrays.asList(line.split(" ")));
		for(String x : set)
			if(Integer.parseInt(x) % 2 == 0)
				evens.add(Integer.parseInt(x));
			else
				odds.add(Integer.parseInt(x));
	}

	public String toString()
	{
		return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
	}
}