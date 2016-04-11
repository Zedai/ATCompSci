package monsters;

import java.util.Scanner;

public class PQRunner
{
	public static void main ( String[] args )
	{
		YourPQ test = new YourPQ();

		Scanner keyboard=new Scanner(System.in);



		System.out.println("How many monsters do you wish to enter?");
		int size = Integer.parseInt(keyboard.nextLine());
		for (int i = 0; i < size; i++) {
			System.out.print("Enter the height :: ");
			int height = Integer.parseInt(keyboard.nextLine());
			System.out.print("\nEnter the weight :: ");
			int weight = Integer.parseInt(keyboard.nextLine());
			System.out.print("\nEnter the age :: ");
			int age = Integer.parseInt(keyboard.nextLine());
			System.out.println("\n");
			test.add(new Monster(height, weight, age));
		}
	
	
	


		System.out.println(test);
		System.out.println("getMin() - " + test.getMin());
		System.out.println("removeMin() - " + test.removeMin());		
		System.out.println(test);
		System.out.println("getMin() - " + test.getMin());
		System.out.println("removeMin() - " + test.removeMin());		
		System.out.println(test);
		
		
		//add more test cases
		
		keyboard.close();
	}
}