package clebAnswears;

import java.util.Iterator;
import java.util.HashSet;

public class cpClub {
	private HashSet<Student> org;

	public cpClub() {
		org = new HashSet<Student>();
	}

	public boolean join(Student x) {
		return org.add(x);
	}

	public HashSet<Student> union(cpClub x) {
		HashSet<Student> un = new HashSet<Student>();
		Iterator<Student> one = org.iterator();
		while (one.hasNext())
			un.add(one.next());

		Iterator<Student> two = x.org.iterator();
		while (two.hasNext())
			un.add(two.next());

		return un;
	}

	public HashSet<Student> union2(cpClub x) {
		HashSet<Student> un = new HashSet<Student>();

		for (Student one : org)
			un.add(one);
		for (Student two : x.org)
			un.add(two);

		return un;
	}

	public HashSet<Student> intersection(cpClub x) {
		Student current;
		HashSet<Student> inter = new HashSet<Student>();
		Iterator<Student> i = org.iterator();
		while (i.hasNext()) {
			current = i.next();
			if (!x.org.add(current))
				inter.add(current);
		}

		return inter;
	}
	
	
}