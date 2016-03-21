package wkst2;

public class ListFunHouse
{
	//this method will print the entire list on the screen
   public static void print(ListNode list)
   {
	   System.out.print("[" + list.getValue());
	   list = list.getNext();
	   while(list != null){
		   System.out.print(", " + list.getValue());
		   list = list.getNext();
	   }
	   System.out.print("]");
   }		
	
	//this method will return the number of nodes present in list
	public static int nodeCount(ListNode list)
	{
		int count=0;
		
		while(list != null){
			list = list.getNext();
			count++;
		}
		return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node to the list.  Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list)
	{
		ListNode first = list;
		ListNode second = new ListNode(first.getValue(), first.getNext());
		first.setNext(second);
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public static void doubleLast(ListNode list)
	{		
		while(list.getNext() != null)
			list = list.getNext();
		
		list.setNext(new ListNode(list.getValue(), null));
	}
		
	//method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list)
	{
		removeXthNode(list, 2);
	}

	//this method will set the value of every xth node in the list
	@SuppressWarnings("rawtypes")
	public static void setXthNode(ListNode list, int x, Comparable value)
	{
		int count=1;
		while(list != null){
			if(count % x == 0)
				list.setValue(value);
			list = list.getNext();
			count++;
		}
		
	}	

	//this method will remove every xth node in the list
	public static void removeXthNode(ListNode list, int x)
	{
		int count=1;
		while(list!=null){
			ListNode next = list.getNext();
			if((count + 1) % x==0){
				if(next!=null){
					ListNode next2 = next.getNext();
					list.setNext(next2);
					count++;
				}
			}
			count++;
			list=list.getNext();
		}
	}
}