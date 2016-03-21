package histogram;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Histogram
{
	private Map<String,Integer> histogram;

	public Histogram(String sent)
	{
		histogram = new TreeMap<String, Integer>();
		setSentence(sent);
	}
	
	public void setSentence(String sent)
	{
		for(char x : sent.toCharArray())
			if(!histogram.containsKey(x + ""))
				histogram.put(x + "", 1);
			else 
				histogram.put(x + "", histogram.get(x + "") + 1);
				
	}

	public String toString()
	{
		String output="";
		Set<Entry<String, Integer>> ts = histogram.entrySet();
		for(Entry<String, Integer> x : ts)
			output += x.getKey() + "\t" + populate(x.getValue()) + "\n";
		
		return output+"\n\n";
	}
	
	public String populate(int n){
		if(n == 1)
			return "*";
		
		return "*" + populate(n - 1);
	}
}