package doublylinkedlist;

public class DListIterator {

	private DListNode current;
	private DListNode previous;
	private DLinkedList myList;
	@SuppressWarnings("unused")
	private boolean canRemove; // for remove() method. true if OK to call

	public DListIterator(DLinkedList list) {
		myList = list;
		if(list == null)
			current = null;
		else 
			current = list.getFirstNode();
		previous = null;
		canRemove = false;
	}

	public String toString() {	
		return myList.toString();
	}

	public boolean hasPrevious() {
		return myList != null && myList.getFirstNode() != current;
	}

	public boolean hasNext() {
		return myList != null && current != null;
	}

	public Object next() {
		if(!hasNext())
			return null;
		previous  = current;
		current = current.getNext();
		return previous;
	}

	public Object previous() {
		if(hasPrevious()){
			if(current == null){
				current = myList.getLastNode();
				previous = current;
				return current;
			}
				
			current = current.getPrevious();
			previous = current;
			return current;
		}		
		
		return null;
	}

	public void remove() {
		if(previous != null){
			if(previous.getPrevious() == null){
				myList.removeFirst();
				current = myList.getFirstNode();
				previous = null;
				return;
			}
			else if(current == null){
				myList.removeLast();
				previous = null;
			}
			else if(current == previous){
				current.getPrevious().setNext(current.getNext());
				if(current.getNext() != null)
					current.getNext().setPrevious(current.getPrevious());
				else
					myList.removeLast();
				current = current.getNext();
				previous = null;
			}
			else{
				previous.getPrevious().setNext(current);
				current.setPrevious(previous.getPrevious());
				previous = null;
			}
		}
	}

	public void add(Object element) {
		if(myList == null || myList.size() == 0){
			myList = new DLinkedList();
			myList.addFirst(element);
			current = null;
			previous = myList.getFirstNode();
		}
		else if(current == null){
			myList.addLast(element);
			previous = myList.getLastNode();
		}					
		else if(current == myList.getFirstNode()){
			myList.addFirst(element);
			current = myList.getFirstNode().getNext();
			previous = myList.getFirstNode();
		}
		else{
			DListNode search = myList.getFirstNode();
			while(search != current)
				search = search.getNext();
			
			DListNode add = new DListNode(element, search, search.getPrevious());
			search.getPrevious().setNext(add);
			search.setPrevious(add);
		}
	}

	public void set(Object element) {
		if(previous != null)
			previous.setValue(element);
	}
} 