package prioritiesInCheck;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.util.Queue;
import java.util.PriorityQueue;

public class PQTester
{
	private Queue<String> pQueue;

	public PQTester()
	{
		setPQ("");
	}

	public PQTester(String list)
	{
		setPQ(list);
	}

	public void setPQ(String list)
	{
		pQueue = new PriorityQueue<String>();
		for(String s : list.split(" "))
		{
			pQueue.add(s);
		}
	}
	
	public Object getMin()
	{
		return pQueue.peek();
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