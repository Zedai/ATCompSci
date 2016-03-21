package wkst;

import java.util.LinkedList;
import java.util.ListIterator;

public class JavaLinkedList
{
	private LinkedList<Integer> list;

	public JavaLinkedList()
	{
		list = new LinkedList<Integer>();
	}

	public JavaLinkedList(int[] nums)
	{
		list = new LinkedList<Integer>();
		for(int num : nums)
		{
			list.add(num);
		}
	}

	public double getSum(  )
	{
		double total=0;
		ListIterator<Integer> iter = list.listIterator();
		
		while(iter.hasNext())
			total += iter.next();
		
		return total;
	}

	public double getAvg(  )
	{
		return ((double)getSum()) / getCount();
	}

	public int getLargest()
	{
		ListIterator<Integer> iter = list.listIterator();
		
		int largest = iter.next();
		
		while(iter.hasNext())
			if(iter.next() > largest)
				largest = iter.previous();
		
		return largest;
	}

	public int getCount(){
		int count = 0;
		ListIterator<Integer> iter = list.listIterator();
		
		while(iter.hasNext()){
			count++;
			iter.next();
		}
		
		return count;
	}
	
	public int getSmallest()
	{
		ListIterator<Integer> iter = list.listIterator();
		int smallest = iter.next();
		
		while(iter.hasNext())
			if(iter.next() < smallest)
				smallest = iter.previous();
		return smallest;
	}

	public String toString()
	{
		return list.toString();
	}
}