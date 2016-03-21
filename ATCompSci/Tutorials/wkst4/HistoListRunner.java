package wkst4;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - Saikiran Nakka
//Date - 11/09/15
//Class - Advanced Topics in Computer Science Honors
//Lab  - Lol



public class HistoListRunner
{
	public static void main(String[] args)
	{
		//A A A A B V S E A S A A
		HistoList test = new HistoList();
		test.addLetter('A');
		test.addLetter('A');
		test.addLetter('A');
		test.addLetter('A');
		test.addLetter('B');
		test.addLetter('V');
		test.addLetter('S');
		test.addLetter('E');
		test.addLetter('A');
		test.addLetter('S');
		test.addLetter('A');
		test.addLetter('A');
		System.out.println(test);


		//A B C
		test = new HistoList();
		test.addLetter('A');
		test.addLetter('B');
		test.addLetter('C');
		System.out.println(test);


		//A B C A B C A B C A B C A B C
		test = new HistoList();
		test.addLetter('A');
		test.addLetter('B');
		test.addLetter('C');
		test.addLetter('A');
		test.addLetter('B');
		test.addLetter('C');
		test.addLetter('A');
		test.addLetter('B');
		test.addLetter('C');
		test.addLetter('A');
		test.addLetter('B');
		test.addLetter('C');
		test.addLetter('A');
		test.addLetter('B');
		test.addLetter('C');
		System.out.println(test);
		
		test = new HistoList();
		test.addLetter('A');
		test.addLetter('A');
		test.addLetter('A');
		test.addLetter('A');
		test.addLetter('B');
		test.addLetter('V');
		test.addLetter('S');
		test.addLetter('E');
		test.addLetter('A');
		test.addLetter('S');
		test.addLetter('A');
		test.addLetter('A');
		
		test.remove('E');
		test.remove('B');
		test.remove('A');
		test.remove('A');
		test.remove('A');
		
		System.out.println("\n\n\nExtension:\n\tRemoving one E, one B, and three A's From the first HistoList");
		System.out.println(test);
	}
}