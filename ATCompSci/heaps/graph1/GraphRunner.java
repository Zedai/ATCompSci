package graph1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphRunner
{
	public static void main( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File("H:\\git\\ATCompSci\\ATCompSci\\heaps\\graph1\\graph1.dat"));
		int howManyTimes = Integer.parseInt(file.nextLine());
		for(int x=0; x<howManyTimes; x++)
		{
			Graph g = new Graph(" " + file.nextLine());
			String check = file.nextLine();
			ArrayList<String> arr = new ArrayList<String>();
			arr.add(check.substring(0, 1));
			g.check(check.substring(0, 1), check.substring(1), arr);
			System.out.println(check.substring(0, 1) + " connects to " + check.substring(1) + " == " + g.match);
		}
		file.close();
	}
}