package united;

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

public class MathSet
{
	private Set<String> one;
	private Set<String> two;

	public MathSet(String o, String t)
	{
		one = new TreeSet<String>(Arrays.asList(o.split(" ")));
		two = new TreeSet<String>(Arrays.asList(t.split(" ")));
	}

	public Set<Integer> union()
	{
		Set<Integer> ret = new TreeSet<Integer>();
		
		for(String s : one)
			ret.add(Integer.parseInt(s));

		for(String s : two)
			ret.add(Integer.parseInt(s));
		
		return ret;
	}

	public Set<Integer> intersection()
	{
		Set<Integer> ret = new TreeSet<Integer>();
		
		for(String s : one)
			if(two.contains(s))
				ret.add(Integer.parseInt(s));
		
		return ret;
	}

	public Set<Integer> differenceAMinusB()
	{
		Set<Integer> ret = new TreeSet<Integer>();
		
		for(String s : one)
			if(!two.contains(s))
				ret.add(Integer.parseInt(s));
		
		return ret;
	}

	public Set<Integer> differenceBMinusA()
	{
		Set<Integer> ret = new TreeSet<Integer>();
		
		for(String s : two)
			if(!one.contains(s))
				ret.add(Integer.parseInt(s));
		
		return ret;
	}
	
	public Set<Integer> symmetricDifference()
	{		
		Set<Integer> ret = new TreeSet<Integer>();
		ret.addAll(differenceAMinusB());
		ret.addAll(differenceBMinusA());
		
		return ret;
	}	
	
	public String toString()
	{
		Set<Integer> intOne = new TreeSet<Integer>(), intTwo = new TreeSet<Integer>();
		for(String x : one)
			intOne.add(Integer.parseInt(x));
		for(String x : two)
			intTwo.add(Integer.parseInt(x));
		
		return "Set one " + intOne + "\n" +	"Set two " + intTwo +  "\n";
	}
}