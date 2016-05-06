package weighted;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class WeightedGraph {
	private TreeMap<String, HashSet<String>> map;
	boolean match = false;
	int shortestTime = 0, shortestDistance = 0, shortestCost = 0;
	ArrayList<Node> graph = new ArrayList<Node>();

	public WeightedGraph(Scanner file) {
		while (file.hasNextLine()) {
			String[] a = file.nextLine().split(" ");
			boolean one = true, two = true;
			for (Node x : graph) {
				if (x.getName().equalsIgnoreCase(a[0].substring(0, 1))) {
					one = false;
					x.addEdge(new Edge(a[0].substring(0, 1), a[0].substring(1),
							a[1], a[2], a[3]));
				}
				if (x.getName().equalsIgnoreCase(a[0].substring(1))) {
					two = false;
					x.addEdge(new Edge(a[0].substring(1), a[0].substring(0, 1),
							a[1], a[2], a[3]));
				}
			}
			if (one) {
				Node n = new Node(a[0].substring(0, 1));
				n.addEdge(new Edge(a[0].substring(0, 1), a[0].substring(1),
						a[1], a[2], a[3]));
				graph.add(n);
			}
			if (two) {
				Node n = new Node(a[0].substring(1));
				n.addEdge(new Edge(a[0].substring(1), a[0].substring(0, 1),
						a[1], a[2], a[3]));
				graph.add(n);
			}
		}
	}

	public void checkTime(String one, String two, ArrayList<String> been, int steps) {
		if (map.get(one).contains(two)) {
			match = true;
			if (shortestTime == 0 || steps <= shortestTime)
				shortestTime = steps;
		} else {
			HashSet<String> set = map.get(one);
			for (String x : set) {
				boolean add = false;
				if (!been.contains(x)) {
					add = true;
					been.add(x);
					checkTime(x, two, been, steps + 1);
				}
				if (add)
					been.remove(x);
			}
		}
	}

	// for (int i = 1; i < a.length; i++) {
	// if (map.containsKey(a[i].substring(0, 1))) {
	// HashSet<String> t = map.get(a[i].substring(0, 1));
	// t.add(a[i].substring(1));
	// map.put(a[i].substring(0, 1), t);
	// } else {
	// HashSet<String> t = new HashSet<String>();
	// t.add(a[i].substring(1));
	// map.put(a[i].substring(0, 1), t);
	// }
	//
	// if (map.containsKey(a[i].substring(1))) {
	// HashSet<String> t = map.get(a[i].substring(1));
	// t.add(a[i].substring(0, 1));
	// map.put(a[i].substring(1), t);
	// } else {
	// HashSet<String> t = new HashSet<String>();
	// t.add(a[i].substring(0, 1));
	// map.put(a[i].substring(1), t);
	// }
	// }
}
