package relatives;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RelativesRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner s = new Scanner(new File("H:\\workspace\\ATCompSci\\somemaps\\relatives\\relatives.dat"));		
		Relatives r = new Relatives();
		int cap = Integer.parseInt(s.nextLine());
		
		for(int i = 0; i < cap; i++)
			r.setPersonRelative(s.nextLine());
		
		System.out.println(r + "\n\n");
		System.out.println(r.getRelatives("Dot"));
		
		s.close();
	}
}