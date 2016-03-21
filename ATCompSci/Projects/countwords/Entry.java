package countwords;

@SuppressWarnings("rawtypes")
public class Entry implements Comparable{
	private String name;
	private int frequency;
	
	public Entry(String name){
		this.name = name;
		frequency = 1;
	}
	
	public void add(){
		frequency++;
	}
	
	public String getName(){
		return name;
	}
	
	public int getFreq(){
		return frequency;
	}
	
	public String toString(){
		return name + "     " + frequency;
	}

	public int compareTo(Object arg0) {
		Entry other = (Entry)(arg0);
		return other.getFreq() - this.getFreq();
	}
}
