package pheme;

public class PhoneEntry implements Comparable<PhoneEntry>{
	private String name, number;
	
	public PhoneEntry(String na, String nu){
		name = na;
		number = nu;
	}
	
	public String getName(){
		return name;
	}
	
	public String getNumber(){
		return number;
	}
	
	public String changeNum(String newNum){
		String oldNum = number;
		number = newNum;
		return oldNum;
	}
	public int hashCode(){
		int sum = 0;
		for(char s : name.toCharArray())
			sum += s;
		
		return sum;
	}
	
	public boolean equals(Object o){
		if(!(o instanceof PhoneEntry))
			return false;
		
		PhoneEntry i = (PhoneEntry) o;
		return i.name.equals(name) && i.number.equals(number);
	}
	
	public String toString(){
		return name + "   " + number;
	}

	@Override
	public int compareTo(PhoneEntry arg0) {
		return name.compareTo(arg0.name);
	}
}