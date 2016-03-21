package prioritiesInCheck;

import java.util.Queue;
import java.util.PriorityQueue;

public class MonsterPQ  
{
	private Queue<Monster> pQueue;

	public MonsterPQ()
	{
		pQueue = new PriorityQueue<Monster>();
	}

	public void add(Monster obj)
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