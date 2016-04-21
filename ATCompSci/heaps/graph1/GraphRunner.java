package graph1;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -  

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

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
			g.check(check.substring(0, 1), check.substring(1), check.substring(0, 1));
			System.out.println(g.match);
		}
		file.close();
	}
}