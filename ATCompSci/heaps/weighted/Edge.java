package weighted;

public class Edge {
	private String one, two;
	private double length, cost, time;
	
	public Edge(String one, String two, String dist, String speed, String c){
		this.one = one;
		this.two = two;
		length = Double.parseDouble(dist);
		cost = Double.parseDouble(c);
		time = (60.0/Double.parseDouble(speed)) * Double.parseDouble(dist);			//Converts Distance and Speed to Time in minutes.
	}

	public String getOne(){
		return one;
	}
	
	public String getTwo(){
		return two;
	}
	
	public double getLength(){
		return length;
	}
	
	public double getCost(){
		return cost;
	}
	
	public double getTime(){
		return time;
	}
}