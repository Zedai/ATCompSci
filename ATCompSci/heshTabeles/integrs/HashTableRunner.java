package integrs;

import java.util.Scanner;
import java.io.File;

public class HashTableRunner
{
  public static void main ( String[] args )
  {
		try{
			HashTable table = new HashTable();
			Scanner in = new Scanner(new File("H:\\workspace\\ATCompSci\\heshTabeles\\integrs\\numbers.dat"));
			int cap = Integer.parseInt(in.nextLine());
			for(int i = 0; i < cap; i++)
				table.add(in.nextInt());
			
			System.out.println(table);
			in.close();
		}
		catch(Exception e)
		{
			System.out.println("Houston, we have a problem!");
		}
  }
}