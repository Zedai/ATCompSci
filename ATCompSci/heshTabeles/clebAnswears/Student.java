package clebAnswears;

public class Student { 
	public String name; 
	public int id; 

	//Constructor for objects of class SATStudent 

	public Student() { 
		this("Connolly", 43213); 
	} 

	public Student(String myName, int myId) { 
		name = myName; 
		id = myId; 
	} 

	public String getName() 

	{ 
		return name; 
	} 

	public int getId() { 
		return id; 
	} 

	public int hashCode() { 
		final int HASH_MULTIPLIER = 29; 
		int h1 = name.hashCode(); 
		int h2 = new Integer(id).hashCode(); 
		int h = HASH_MULTIPLIER * h1 + h2; 
		return h; 
	} 

	public boolean equals(Object other) { 
		if (other == null) 
			return false; 

		if (getClass() != other.getClass()) 
			return false; 

		return (id == ((Student) other).getId() && name.equals(((Student) other).name));	
	} 

	public String toString() { 
		return name + "  " + id; 
	}
}