package weighted;

public class Edge {
	private String one, two;
	private int length, cost;
	private double time;
	
	public Edge(String one, String two, String dist, String speed, String c){
		this.one = one;
		this.two = two;
		length = Integer.parseInt(dist);
		cost = Integer.parseInt(c);
		time = (60.0/Integer.parseInt(speed)) * Integer.parseInt(dist);
	}

	public String getOne(){
		return one;
	}
	
	public String getTwo(){
		return two;
	}
	
	public int getLength(){
		return length;
	}
	
	public int getCost(){
		return cost;
	}
	
	public double getTime(){
		return time;
	}
}
