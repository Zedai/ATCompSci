package monsters;

class Monster implements Comparable<Monster> {

	private int height, weight, age;

	public Monster(int ht, int wt, int age) {
		height = ht;
		weight = wt;
		this.age = age;
	}

	public void setWeight(int wt) {
		weight = wt;
	}

	public void setHeight(int ht) {
		height = ht;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Object clone() {
		return new Monster(weight, height, age);
	}

	public int getWeight() {
		return weight;
	}

	public int getHeight() {
		return height;
	}

	public int getAge() {
		return age;
	}

	public boolean equals(Object o) {
		Monster ms = (Monster) o;
		return ms.getAge() == getAge() && ms.getWeight() == getWeight()
				&& ms.getHeight() == getHeight();
	}

	public int compareTo(Monster rhs) {
		if (getHeight() == rhs.getHeight())
			if (getWeight() == rhs.getWeight())
				return getAge() - rhs.getAge();
			else
				return getWeight() - rhs.getWeight();
		return getHeight() - rhs.getHeight();
	}

	public String toString() {
		return "" + getHeight() + ", " + getWeight() + ", " + getAge();
	}
}