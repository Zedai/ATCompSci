package clebs;

import java.io.File;
import java.io.FileNotFoundException;

public class TestPls {
	public static void main(String[] args) throws FileNotFoundException{
		ClubMap cm = new ClubMap(new File("H:\\workspace\\ATCompSci\\heshTabeles\\clebs\\student - goes with club mapping.txt"));
		cm.displayByClub();
		System.out.println("\n\n\n\n");
		cm.displayByClub("Math");
	}
}
