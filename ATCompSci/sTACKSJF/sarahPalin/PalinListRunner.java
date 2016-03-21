package sarahPalin;

public class PalinListRunner
{
	public static void main ( String[] args )
	{
		PalinList palin = new PalinList("one two three two one");
		System.out.println(palin + "   Palindrome:: " + palin.isPalin());
		palin = new PalinList("1 2 3 4 5 one two three four five");
		System.out.println(palin + "   Palindrome:: " + palin.isPalin());
		palin = new PalinList("a b c d e f g x y z g f h");
		System.out.println(palin + "   Palindrome:: " + palin.isPalin());
		palin = new PalinList("racecar is racecar");
		System.out.println(palin + "   Palindrome:: " + palin.isPalin());
		palin = new PalinList("1 2 3 a b c c b a 3 2 1");
		System.out.println(palin + "   Palindrome:: " + palin.isPalin());
		palin = new PalinList("chicken is a chicken");
		System.out.println(palin + "   Palindrome:: " + palin.isPalin());
	}
}