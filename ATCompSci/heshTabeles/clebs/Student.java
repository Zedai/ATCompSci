package clebs;

import java.util.Scanner;

public class Student implements Comparable<Student>{
	private String first, last, id;
	
	public Student(String x){
		x = x.trim();
		Scanner read = new Scanner(x);
		last = read.next();
		first = read.next();
		id = read.next();
		read.close();
	}
	
	public String getFirst(){
		return first;
	}

	public String getLast(){
		return last;
	}
	
	public String getID(){
		return id;
	}
	
	public String toString(){
		return last + ", " + first + " :: " + id;
	}
	
//	public int hashCode(){
//		final int HASH_MULTIPLIER = 29;
//		int h1 = (first + last).hashCode();
//		int h2 = new Integer(id).hashCode();
//		int h = HASH_MULTIPLIER*h1+h2;
//		return h;
//	}
	
	public boolean equals(Object other){
		if(!(other instanceof Student))
			return false;
		
		Student o = (Student)other;
		return first == o.getFirst() && last == o.getLast() && id == o.getID();
	}

	@Override
	public int compareTo(Student o) {
		if(this.last.equals(o.last))
			if(this.first.equals(o.first))
				return this.id.compareTo(o.id);
			else
				return this.first.compareTo(o.first);
		
		return this.last.compareTo(o.last);
	}
}