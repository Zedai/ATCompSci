package wkst3;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - Saikiran Nakka
//Date - 11/03/15
//Class - AT Com Sci
//Lab  - Idk



public class ListFunHouseTwo
{
	private ListNode theList;
	
	public ListFunHouseTwo()
	{

	}
	
	@SuppressWarnings("rawtypes")
	public void add(Comparable data)
	{
		if(theList != null){
			ListNode list = theList;
			while(list != null && list.getNext() != null)
				list = list.getNext();
		
			ListNode prev = list;		
			list.setNext(new ListNode(data, null, prev));
		}
		else
			theList = new ListNode(data, null, null);
	}
	
	//this method will return the number of nodes present in list
	public int nodeCount()
	{
		ListNode list = theList;
		int count=0;
   		while(list != null){
   			count++;
   			list = list.getNext();
   		}
	
   	return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node at the front of the list.  Once finished, the first node will occur twice.
	public void doubleFirst()
	{
		ListNode list = theList;
		ListNode next = new ListNode(list.getValue(), list.getNext(), null);		
		list.setNext(next);
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public void doubleLast()
	{
		ListNode list = theList;
		while(list != null && list.getNext() != null)
			list = list.getNext();
	
		ListNode prev = list;		
		list.setNext(new ListNode(prev.getValue(), null, prev));

	}
	
	//method skipEveryOther will remove every other node
	public void skipEveryOther()
	{
		removeXthNode(2);
	}

	//this method will set the value of every xth node in the list
	@SuppressWarnings("rawtypes")
	public void setXthNode(int x, Comparable value)
	{
		ListNode list = theList;
		int count = 1;
		while(list != null){
			if(count % x == 0)
				list.setValue(value);
			
			count++;
			list = list.getNext();
		}
	}	

	//this method will remove every xth node in the list
	public void removeXthNode(int x)
	{
		ListNode list = theList;
		int count = 1;
		
		while(list != null){
			ListNode next = list.getNext();
				if((count + 1) % x == 0){
					if(next != null){
						ListNode next2 = next.getNext();
						list.setNext(next2);
						count++;
					}
				}
				
			count++;
			list = list.getNext();
		}
	}		
	//this method will return a String containing the entire list
   public String toString()
   {
	  if(theList == null)
		  return "EMPTY";
	   
	   ListNode list = theList;
   	   String output="";	
	   output += ("[" + list.getValue());
	   list = list.getNext();
	   while(list != null){
		   output += (", " + list.getValue());
		   list = list.getNext();
	   }
	   output += ("]");
   	   return output;
   }			
	
}