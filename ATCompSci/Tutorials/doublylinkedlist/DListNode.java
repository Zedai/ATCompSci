package doublylinkedlist;

public class DListNode
{
	private Object value;
	private DListNode next;
	private DListNode previous;

	public DListNode(Object initValue, DListNode initNext, DListNode initPrev)
	{
		value = initValue;
		next = initNext;
		previous = initPrev;

	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public DListNode getNext() {
		return next;
	}

	public void setNext(DListNode next) {
		this.next = next;
	}

	public DListNode getPrevious() {
		return previous;
	}

	public void setPrevious(DListNode previous) {
		this.previous = previous;
	}
}