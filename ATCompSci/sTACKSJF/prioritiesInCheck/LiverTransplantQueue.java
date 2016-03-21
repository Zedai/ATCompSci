package prioritiesInCheck;

import java.util.ArrayList;

public class LiverTransplantQueue<T extends Comparable<T>> implements PriorityQueue {
	ArrayList<Comparable<T>> list = new ArrayList<Comparable<T>>();

	public String toString() {
		format();
		return list.toString();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(Object x) {
		list.add((Comparable<T>) x);
	}

	@Override
	public Object poll() {
		Comparable<T> ret = list.remove(0);
		format();
		return ret;
	}

	@Override
	public Object peek() {
		return list.get(0);
	}

	@Override
	public int size() {
		return list.size();
	}

	@SuppressWarnings("unchecked")
	private void format() {
		if(size() > 1){
			int min = 0;
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).compareTo((T) list.get(min)) < 0)
					min = i;
			}
			list.add(0, list.remove(min));
		}
	}

	private static class Patient implements Comparable<Patient> {
		String name;
		int priority;

		public Patient(String n, int p) {
			name = n;
			priority = p;
		}

		public int getPriority() {
			return priority;
		}

		public String getName() {
			return name;
		}

		public String toString() {
			return getName();
		}

		@Override
		public int compareTo(Patient other) {
			return getPriority() - other.getPriority();
		}
	}
	
	public static void main(String[] args) {
		LiverTransplantQueue<Patient> pq = new LiverTransplantQueue<Patient>();
		pq.add(new Patient("Smith", 3));
		pq.add(new Patient("Chen", 2));
		pq.add(new Patient("Jones", 3));
		pq.add(new Patient("Wong", 3));
		pq.add(new Patient("Gupta", 2));
		pq.add(new Patient("Garcia", 1));
		pq.add(new Patient("Brown", 3));

		System.out.println("The list is");
		System.out.println(pq);

		while (pq.size() > 0) {
			System.out.println("The next patient for the liver transplant is");
			System.out.println(pq.poll());
		}
	}
}