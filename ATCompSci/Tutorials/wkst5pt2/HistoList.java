package wkst5pt2;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - Saikiran Nakka
//Date -  11/13/15
//Class - AT Comp Sci
//Lab  - Still spooki friday the 13th

public class HistoList
{
	private ListNode front;

	public HistoList( )
	{
	}


	//ADDS NEW NODE TO THE FRONT OF THE LIST FOR LET IF IT DOES NOT EXIST.
	//IF IT EXISTS, IT BUMPS UP LET'S COUNT BY ONE
	public void add(Object obj)
	{		
		if(front ==  null)
		front = new ListNode(new ThingCount(obj, 1), null);
		else{
			ListNode search = front;
			if(indexOf(obj) == -1)
				front = new ListNode(new ThingCount(obj, 1) , search);
			else{
				ThingCount x = (ThingCount)nodeAt(indexOf(obj)).getValue();
				x.setCount(x.getCount() + 1);
			}
		}
	}

	//RETURNS THE INDEX POSITION OF LET IN THE LIST
	public int indexOf(Object obj)
	{
		ListNode search = front;
		int index = 0;
		while(search != null)
			if(((ThingCount)search.getValue()).getThing().equals(obj))
				return index;
			else{
				search = search.getNext();
				index++;
			}

		return -1;
	}

	//RETURNS A REFERENCE TO THE NODE AT SPOT
	private ListNode nodeAt(int spot)
	{
		if(spot < 0)
			return null; 
		
		ListNode search = front;

		for(int i = 0; i < spot; i++)
			search = search.getNext();

		return search;
	}

	//RETURNS THE LIST AS A BIG STRING
	public String toString()
	{
		String output = "";
		ListNode search = front;
		
		while(search != null){
			ThingCount x = (ThingCount)search.getValue();
			output += x.getThing() + " - " + x.getCount() + "\t";
			search = search.getNext();
		}
		
		return output;
	}
}