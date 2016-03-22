package clebs;

import java.io.File;
import java.io.FileNotFoundException;

public class TestPls {
	public static void main(String[] args) throws FileNotFoundException{
		long before = System.currentTimeMillis();
		
		ClubMap cm = new ClubMap(new File("H:\\git\\ATCompSci\\ATCompSci\\heshTabeles\\clebs\\student - goes with club mapping.txt"));
		cm.displayByClub();
		System.out.println("\n\n\n\n");
		
		while(System.currentTimeMillis() - before < 2000){
			
		}
		cm.displayByClub("Math");
		
		long after = System.currentTimeMillis();
		System.out.println("elapsed time: " + (after - before) + "ms");

	}
}
