package oddEven;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OddRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner in = new Scanner(new File("H:\\workspace\\ATCompSci\\somesets\\oddEven\\oddevendata.dat"));
		
		while(in.hasNextLine()){
			System.out.println(new OddEvenSets(in.nextLine()));
		}
		in.close();
	}
}