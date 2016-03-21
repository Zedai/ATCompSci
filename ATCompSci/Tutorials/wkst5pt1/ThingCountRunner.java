package wkst5pt1;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - Saikiran Nakka
//Date -  11/13/15
//Class - AT Comp Sci
//Lab  - Spooki Friday the 13th

public class ThingCountRunner
{
	public static void main(String[] args)
	{
		ThingCount one = new ThingCount();
		ThingCount two = new ThingCount('A',5);
		
		System.out.println(one);
		System.out.println(two);
		
		ThingCount three = new ThingCount("hello", 7);
		System.out.println(three);
		System.out.println(three.getCount());
		three.setCount(22);
		three.setThing(54.12);
		System.out.println(three);		
		
		System.out.println(three.equals(two));
		two.setCount(22);
		two.setThing(54.12);		
		System.out.println(two.equals(three));		
	}
}