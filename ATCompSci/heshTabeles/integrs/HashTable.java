package integrs;

import java.util.LinkedList;

public class HashTable
{
	private LinkedList<Number>[] table;

	@SuppressWarnings("unchecked")
	public HashTable( )
	{
		table = new LinkedList[10];
		for(int i = 0; i < 10; i++){
			table[i] = new LinkedList<Number>();
		}
	}

	public void add(int obj)
	{
		System.out.println("add");
		
		Number o = new  Number(obj);
		int i = o.hashCode();
		if(!table[i].contains(o))
			table[i].addLast(o);
	}

	public String toString()
	{
		String output="HASHTABLE\n";
		for(int i = 0; i < 10; i++){
			output += "\nBucket " + i + " ::";
			for(Number x : table[i])
				output += " " + x.getValue();
		}

		return output;
	}
}