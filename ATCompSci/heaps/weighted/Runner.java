package weighted;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner file = new Scanner(new File("H:\\git\\ATCompSci\\ATCompSci\\heaps\\weighted\\graph.dat"));
		WeightedGraph g = new WeightedGraph(file);
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("A");
		g.checkTime("A", "D", arr, 0);
		g.checkCost("A", "D", arr, 0);
		g.checkDistance("A", "D", arr, 0);
		System.out.println(g.shortestTime + " minutes");
		System.out.println(g.shortestDistance + " miles");
		System.out.println(g.shortestCost + " dollars");
	}
}