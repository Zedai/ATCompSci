package binerybeeks;

@SuppressWarnings("rawtypes")
public class PhoneEntry implements Comparable{
	private String name;
	private String number;

	public PhoneEntry(String myName, String myNumber) {
		name = myName;
		number = myNumber;
	}

	public String toString() {
		return "Name: " + name + " Number: " + number;
	}

	public String getName(){
		return name;
	}
	
	public String getNumber(){
		return number;
	}
	
	@Override
	public int compareTo(Object arg0) {
		PhoneEntry o = (PhoneEntry)arg0;
		if(this.name.equals(o.name))
			return this.number.compareTo(o.number);
		return this.name.compareTo(o.name);
	}
}