package wkst3;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - Saikiran Nakka
//Date - 11/03/15
//Class - AT Com Sci
//Lab  - Idk

@SuppressWarnings("rawtypes")

public class ListNode implements Linkable
{
	private Comparable listNodeValue;
	private ListNode nextListNode;
	private ListNode prevListNode;

	public ListNode()
	{
		listNodeValue = null;
		nextListNode = null;
		prevListNode = null;
	}

	public ListNode(Comparable value, ListNode next, ListNode prev)
	{
		listNodeValue = value;
		nextListNode = next;
		prevListNode = prev;
	}

	public Comparable getValue()
	{
		return listNodeValue;
	}

	public ListNode getNext()
	{
	   return nextListNode;
	}

	public ListNode getPrev(){
		return prevListNode;
	}
	
	public void setPrev(Linkable prev){
		prevListNode = (ListNode)prev;
		
		if(prev != null && prevListNode.getNext() != this)
			prevListNode.setNext(this);
	}
	
	public void setValue(Comparable value)
	{
		listNodeValue = value;
	}

	public void setNext(Linkable next)
	{
		nextListNode = (ListNode)next;
		
		if(next != null && nextListNode.getPrev() != this)
			nextListNode.setPrev(this);
	}
}