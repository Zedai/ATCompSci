package rassling;

public class Wrestler {
	private String name;
	private int weight;

	public Wrestler(String theName, int theWeight) {
		name = theName;
		weight = theWeight;
	}

	public int getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}

	public void addWeight(int t){
		weight += t;
	}
	
	public String toString() {
		return name + "  " + weight;
	}
}