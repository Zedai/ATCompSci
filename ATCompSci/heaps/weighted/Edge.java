package weighted;

public class Edge {
	private String one, two;
	private int weight;
	
	public Edge(String one, String two, int w){
		this.one = one;
		this.two = two;
		weight = w;
	}

	public String getOne(){
		return one;
	}
	
	public String getTwo(){
		return two;
	}
	
	public int getWegiht(){
		return weight;
	}
}
