package weighted;

import java.util.ArrayList;

public class Node {
	private String name;
	private ArrayList<Edge> neighbors = new ArrayList<Edge>();
	
	public Node(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public void addEdge(Edge e){
		neighbors.add(e);
	}
	
//	public void removeEdge(){
//		
//	}
	
	public ArrayList<Edge> getEdges(){
		return neighbors;
	}
}
