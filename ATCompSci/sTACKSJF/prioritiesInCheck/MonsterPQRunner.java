package prioritiesInCheck;

import java.util.Scanner;

public class MonsterPQRunner {
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		MonsterPQ m = new MonsterPQ();
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
			m.add(new Monster(height, weight, age));
		}

		System.out.println(m);
		for (int i = 0; i < size; i++) {
			System.out.println(m.getMin());
			System.out.println(m.removeMin());
			System.out.println(m);
		}
	}
}