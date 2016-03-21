package doublylinkedlist;

@SuppressWarnings("unused")
public class DLinkedList {
	private DListNode firstNode;
	private DListNode lastNode;

	/**
	 * 
	 * Construct an empty list
	 */
	public DLinkedList() {
		firstNode = null;
		lastNode = null;
	}

	/**
	 * 
	 * Returns true if the list contains no elements
	 */
	public boolean isEmpty() {
		DListNode node = firstNode;
		while(node != null){
			if(node.getValue() != null)
				return false;
			node = node.getNext();
		}
		
		return true;
	}

	public DListNode getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(DListNode firstNode) {
		this.firstNode = firstNode;
	}

	public DListNode getLastNode() {
		return lastNode;
	}

	public void setLastNode(DListNode lastNode) {
		this.lastNode = lastNode;
	}

	/**
	 * 
	 * Inserts the argument as the first element of this list.
	 */
	public void addFirst(Object o) {
		if(firstNode == null){
			firstNode = new DListNode(o, null,  null);
			lastNode = firstNode;
		}
		else {
		DListNode first = new DListNode(o, firstNode, null);
		firstNode.setPrevious(first);
		firstNode = first;
		
		DListNode node = firstNode;
		while(node.getNext() != null)
			node = node.getNext();

		lastNode = node;
		}
	}

	/**
	 * 
	 * Inserts the argument as the last element of this list.
	 */
	public void addLast(Object o) {
		DListNode last = new DListNode(o, null, lastNode);
		lastNode.setNext(last);
		lastNode = last; 
	}

	/**
	 * 
	 * Removes and returns the first element of this list.
	 */
	public Object removeFirst() {
		if(firstNode == null)
			return null;
		
		Object o = firstNode.getValue();
		
		if(lastNode == firstNode){
			firstNode = null;
			lastNode = null;
			return o;
		}
		
		firstNode.getNext().setPrevious(null);
		DListNode first = firstNode.getNext();
		firstNode = first;
		return o;
	}

	/**
	 * 
	 * Removes and returns the last element of this list.
	 */
	public Object removeLast() {
		if(lastNode == null)
			return null;
		
		Object o = lastNode.getValue();

		if(lastNode == firstNode){
			firstNode = null;
			lastNode = null;
			return o;
		}
		else if(firstNode.getNext() == lastNode || lastNode.getPrevious() == firstNode){
			firstNode.setNext(null);
			lastNode = firstNode;
			return o;
		}
		
		
		DListNode node = firstNode;
		while(node.getNext().getNext() != null)
			node = node.getNext();

		node.setNext(null);
		lastNode = node;
		return o;
	}

	/**
	 * 
	 * Returns a String representation of the list.
	 */
	public String toString() {
		if(isEmpty())
			return "EMPTY";
		String output = "[";
		DListNode node = firstNode;
		if(node != null){
			output += node.getValue();
			node = node.getNext();
		}
		
		while(node != null){
			output += ", " + node.getValue();
			node = node.getNext();
		}
		
		output += "]";
		return output;
	}

	/**
	 * 
	 * Returns the number of elements in the list as an int.
	 */
	public int size() {
		DListNode node = firstNode;
		int count = 0;
		
		while(node != null){
			node = node.getNext();
			++count;
		}
		
		return count;
	}

	/**
	 * 
	 * Removes all of the elements from this list.
	 */
	private void clear() {
		firstNode = null;
		lastNode = null;
	}

	/**
	 * 
	 * Returns a DListIterator.
	 */
	public DListIterator iterator() {

		return new DListIterator(this);

	}
}