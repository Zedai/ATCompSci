package card;

public class CardTester {
	public static void main(String[] args){
//		Card a = new Card();
//		Card b = new Card(2, 14);
//		System.out.println(a);
//		System.out.println(b);
//		
//		Deck deck = new Deck();
//		System.out.println(deck);
		
		Deck a = new Deck();
		System.out.println(a);
//		 a.bridgeShuffle();
//		 a.cut();
		a.completeShuffle();
		System.out.println(a);
		for (int i = 1; i <= 5; i++)
			System.out.println(a.deal());

	}
}
