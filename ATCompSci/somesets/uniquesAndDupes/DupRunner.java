package uniquesAndDupes;

public class DupRunner
{
	public static void main( String args[] ){
		test("a b c d e f g h a b c d e f g h i j k");
		test("one two three one two three six seven one two");
		test("1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6");
	}
	
	public static void test(String input){
		System.out.println("Original List:: " + input + "\nUniques:: " + UniquesDupes.getUniques(input) + "\nDupes:: " + UniquesDupes.getDupes(input) + "\n\n");
	}
}