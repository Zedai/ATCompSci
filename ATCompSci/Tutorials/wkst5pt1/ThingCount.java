package wkst5pt1;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - Saikiran Nakka
//Date -  11/13/15
//Class - AT Comp Sci
//Lab  - Spooki Friday the 13th

@SuppressWarnings({ "rawtypes" })
public class ThingCount implements Comparable
{
	private int count;
	private Object thing;
	
	public ThingCount()
	{
	}
	
	public ThingCount(Object thang, int cnt)
	{
		count = cnt;
		thing = thang;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setCount(int cnt)
	{
		count = cnt;
	}

	public void setThing(Object obj)
	{
		thing = obj;
	}	
	
	public Object getThing()
	{
		return thing;
	}
	
	public boolean equals(Object obj)
	{
		ThingCount other = (ThingCount)obj;
		return other.getThing().equals(thing) && other.getCount() == count;
	}
	
	public int compareTo(Object obj)
	{
		ThingCount other = (ThingCount)obj;
		return other.getCount() - count;		
	}
	
	public String toString()
	{
		return ""+ getThing() + " - " + getCount();
	}
}