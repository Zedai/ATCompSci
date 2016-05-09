package weighted;

import java.util.ArrayList;
import java.util.Scanner;

public class WeightedGraph {
	boolean match = false;
	double shortestTime = 0, shortestDistance = 0, shortestCost = 0;
	ArrayList<Node> graph = new ArrayList<Node>();

	public WeightedGraph(Scanner file) {
		while (file.hasNextLine()) {
			String[] a = file.nextLine().split(" ");
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

	public Node get(String one) {
		for (Node x : graph)
			if (x.getName().equalsIgnoreCase(one))
				return x;

		return null;
	}

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
	 * 	Method that determines the shortest time elapsed between two point
	 * @param one Starting point
	 * @param two Ending point
	 * @param been Current Path
	 * @param steps
	 */
	private void checkTime(String one, String two, ArrayList<String> been, double steps) {
		boolean contin = true;
		for (Edge e : get(one).getEdges())
			if (e.getTwo().equalsIgnoreCase(two)) {
				match = true;
				contin = false;
				if (shortestTime == 0 || steps <= shortestTime)
					shortestTime = (steps + e.getTime());
			}

		if (contin) {
			ArrayList<Edge> set = get(one).getEdges();
			for (Edge x : set) {
				boolean add = false;
				if (!been.contains(x.getTwo())) {
					add = true;
					been.add(x.getTwo());
					checkTime(x.getTwo(), two, been, (steps + x.getTime()));
				}
				if (add)
					been.remove(been.size()-1);
			}
		}
	}

	private void checkDistance(String one, String two, ArrayList<String> been, double steps) {
		boolean contin = true;
		for (Edge e : get(one).getEdges())
			if (e.getTwo().equalsIgnoreCase(two)) {
				match = true;
				contin = false;
				if (shortestDistance == 0 || steps <= shortestDistance)
					shortestDistance = (steps + e.getLength());
			}

		if (contin) {
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

	private void checkCost(String one, String two, ArrayList<String> been, double steps) {
		boolean contin = true;
		for (Edge e : get(one).getEdges())
			if (e.getTwo().equalsIgnoreCase(two)) {
				match = true;
				contin = false;
				if (shortestCost == 0 || steps <= shortestCost)
					shortestCost = (steps + e.getCost());
			}

		if (contin) {
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