package united;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MathSetRunner
{
	public static void main(String args[]) throws IOException
	{
		Scanner in = new Scanner(new File("H:\\workspace\\ATCompSci\\somesets\\united\\mathsetdata.dat"));
		
		while(in.hasNextLine()){
			MathSet ms = new MathSet(in.nextLine(), in.nextLine());
			System.out.println(ms);
			System.out.println("union - " + ms.union());
			System.out.println("intersection - " + ms.intersection());
			System.out.println("difference A-B - " + ms.differenceAMinusB());
			System.out.println("difference B-A - " + ms.differenceBMinusA());
			System.out.println("symmetric difference - " + ms.symmetricDifference() + "\n\n");
		}
			
		in.close();
	}
}
