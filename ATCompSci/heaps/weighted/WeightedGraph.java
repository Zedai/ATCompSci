package weighted;

import java.util.ArrayList;
import java.util.Scanner;

public class WeightedGraph {
	boolean match = false;
	double shortestTime = 0, shortestDistance = 0, shortestCost = 0;
	ArrayList<Node> graph = new ArrayList<Node>();

	public WeightedGraph(Scanner file) {
		while (file.hasNextLine()) {											//The constructor instantiates Nodes and adds Edges to 
			String[] a = file.nextLine().split(" ");							//them as more input is being read
			boolean one = true, two = true;
			for (Node x : graph) {
				if (x.getName().equalsIgnoreCase(a[0].substring(0, 1))) {
					one = false;
					x.addEdge(new Edge(a[0].substring(0, 1), a[0].substring(1), a[1], a[2], a[3]));
				}
				if (x.getName().equalsIgnoreCase(a[0].substring(1))) {
					two = false;
					x.addEdge(new Edge(a[0].substring(1), a[0].substring(0, 1), a[1], a[2], a[3]));
				}
			}
			if (one) {
				Node n = new Node(a[0].substring(0, 1));
				n.addEdge(new Edge(a[0].substring(0, 1), a[0].substring(1), a[1], a[2], a[3]));
				graph.add(n);
			}
			if (two) {
				Node n = new Node(a[0].substring(1));
				n.addEdge(new Edge(a[0].substring(1), a[0].substring(0, 1), a[1], a[2], a[3]));
				graph.add(n);
			}
		}
	}

	/**
	 * Gets the Node that correlates to the String
	 * @param one The name of the Node that is being requested
	 * @return node that correlates with the String
	 */
	public Node get(String one) {
		for (Node x : graph)
			if (x.getName().equalsIgnoreCase(one))
				return x;

		return null;
	}
	
	/**
	 * This method selects which check is done; checkCost(), checkDistance(), or checkTime()
	 * @param test Two letter String whose first char is the start point and second index is the end point
	 * @param choice States requested check
	 */
	public void check(String test, Weighted choice) {
		ArrayList<String> array = new ArrayList<String>();
		array.add(test.substring(0, 1));
		switch (choice) {
			case COST:
				checkCost(test.substring(0, 1), test.substring(1), array, 0);
				break;
			case DISTANCE:
				checkDistance(test.substring(0, 1), test.substring(1), array, 0);
				break;
			case TIME:
				checkTime(test.substring(0, 1), test.substring(1), array, 0);
				break;
			default:
				checkTime(test.substring(0, 1), test.substring(1), array, 0);
				break;
		}
	}

	/**
	 * Method that determines the shortest time elapsed between two point
	 * @param one A String that defines the current point
	 * @param two A String that defines the ending point
	 * @param been An ArrayList of String that holds the Nodes that have been visited on the current path
	 * @param steps The double precision floating point number that holds the total weight of the current path
	 */
	private void checkTime(String one, String two, ArrayList<String> been, double steps) {
		boolean cont = true;
		for (Edge e : get(one).getEdges())								//For every Edge that is adjacent to the current Node.
			if (e.getTwo().equalsIgnoreCase(two)) {						//Search to see if the end Node is among the adjacent Nodes.
				match = true;											//If this is the first path, shortest is set, else set if path
				cont = false;											//is less than shortest path.
				if (shortestTime == 0 || steps <= shortestTime)
					shortestTime = (steps + e.getTime());
			}

		if (cont) {
			ArrayList<Edge> set = get(one).getEdges();					
			for (Edge x : set) {												//Iterate through the neighbours of the current Node.
				boolean add = false;											//If you haven't visited the neighbour yet,
				if (!been.contains(x.getTwo())) {							 	//call the check again with the neighbour as the current,
					add = true;													//and adding the old node to been as well as increment
					been.add(x.getTwo());										//the weight of the path
					checkTime(x.getTwo(), two, been, (steps + x.getTime()));
				}
				if (add)												//Backtrack from the above move in order to find other paths
					been.remove(been.size()-1);
			}
		}
	}

	/**
	 * 	Method that determines the shortest distance to travel between two point
	 * @param one A String that defines the current point
	 * @param two A String that defines the ending point
	 * @param been An ArrayList of String that holds the Nodes that have been visited on the current path
	 * @param steps The double precision floating point number that holds the total weight of the current path
	 */
	private void checkDistance(String one, String two, ArrayList<String> been, double steps) {
		boolean cont = true;
		for (Edge e : get(one).getEdges())
			if (e.getTwo().equalsIgnoreCase(two)) {
				match = true;
				cont = false;
				if (shortestDistance == 0 || steps <= shortestDistance)
					shortestDistance = (steps + e.getLength());
			}

		if (cont) {
			ArrayList<Edge> set = get(one).getEdges();
			for (Edge x : set) {
				boolean add = false;
				if (!been.contains(x.getTwo())) {
					add = true;
					been.add(x.getTwo());
					checkDistance(x.getTwo(), two, been, (steps + x.getLength()));
				}
				if (add)
					been.remove(been.size()-1);
			}
		}
	}

	/**
	 * 	Method that determines the cheapest path to travel between two point
	 * @param one A String that defines the current point
	 * @param two A String that defines the ending point
	 * @param been An ArrayList of String that holds the Nodes that have been visited on the current path
	 * @param steps The double precision floating point number that holds the total weight of the current path
	 */
	private void checkCost(String one, String two, ArrayList<String> been, double steps) {
		boolean cont = true;
		for (Edge e : get(one).getEdges())
			if (e.getTwo().equalsIgnoreCase(two)) {
				match = true;
				cont = false;
				if (shortestCost == 0 || steps <= shortestCost)
					shortestCost = (steps + e.getCost());
			}

		if (cont) {
			ArrayList<Edge> set = get(one).getEdges();
			for (Edge x : set) {
				boolean add = false;
				if (!been.contains(x.getTwo())) {
					add = true;
					been.add(x.getTwo());
					checkCost(x.getTwo(), two, been, (steps + x.getCost()));
				}
				if (add)
					been.remove(been.size()-1);
			}
		}
	}
}