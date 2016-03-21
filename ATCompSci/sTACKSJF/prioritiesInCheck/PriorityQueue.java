package prioritiesInCheck;

public interface PriorityQueue {
	boolean isEmpty();
	void add(Object x);
	Object poll();
	Object peek();
	int size();
}