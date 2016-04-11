package monsters;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Queue;
import java.util.PriorityQueue;

@SuppressWarnings("rawtypes")
public class YourPQ
{
	private Queue pQueue;

	public YourPQ()
	{
		pQueue = new PriorityQueue();
	}

	@SuppressWarnings("unchecked")
	public void add(Object obj)
	{
		pQueue.add(obj);
	}
	
	public Object getMin()
	{
		return pQueue.peek();
	}
	
	public Object removeMin()
	{
		return pQueue.poll();
	}
	
	public String getNaturalOrder()
	{
		String output="";
		while(!pQueue.isEmpty())
		{
			output+=pQueue.remove()+ " ";
		}
		return output;		
	}

	public String toString()
	{
		return ""+pQueue;
	}	
}