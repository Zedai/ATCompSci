package weighted;

import java.util.ArrayList;

public class Node {
	private String name;
	private ArrayList<Edge> neighbours = new ArrayList<Edge>();
	
	public Node(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public void addEdge(Edge e){
		neighbours.add(e);
	}
	
	public ArrayList<Edge> getEdges(){
		return neighbours;
	}
}