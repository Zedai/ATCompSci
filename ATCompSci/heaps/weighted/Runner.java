package weighted;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner file = new Scanner(new File("H:\\git\\ATCompSci\\ATCompSci\\heaps\\weighted\\graph.dat"));
		WeightedGraph g = new WeightedGraph(file);
		
		g.check("AD", Weighted.TIME);
		System.out.println(g.shortestTime + " minutes");
		g.check("AD", Weighted.DISTANCE);
		System.out.println(g.shortestDistance + " miles");
		g.check("AD", Weighted.COST);
		System.out.println(g.shortestCost + " dollars");
		file.close();
	}
}