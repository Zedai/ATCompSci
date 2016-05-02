package shortest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShortestPathGraphRunner
{
	public static void main( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File("H:\\git\\ATCompSci\\ATCompSci\\heaps\\shortest\\graph.dat"));
		int howManyTimes = Integer.parseInt(file.nextLine());
		for(int x=0; x<howManyTimes; x++)
		{
			ShortestPathGraph g = new ShortestPathGraph(" " + file.nextLine());
			String check = file.nextLine();
			ArrayList<String> arr = new ArrayList<String>();
			arr.add(check.substring(0, 1));
			g.check(check.substring(0, 1), check.substring(1), arr, 1);
			System.out.println(check.substring(0, 1) + " connects to " + check.substring(1) + " == " + g.match + " in " + g.shortest + " steps");
		}
		file.close();

	}
}