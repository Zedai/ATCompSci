package card;

import java.util.Stack;

public class Deck {
	Stack<Card> deck;
	
	public Deck() {
		deck = new Stack<Card>();
		loadDeck();
	}

	public void loadDeck() {
		for (int s = 1; s <= 4; s++)
			for (int v = 2; v <= 14; v++)
				deck.push(new Card(s, v));
	}

	public String toString() {
		Stack<Card> temp = new Stack<Card>();
		deck = reverse(deck);
		String string = "";
		for(int r = 0; r < 13; r++){
			for(int c = 0; c < 4; c++){
				Card next = deck.pop();
				temp.push(next);
				string += next + "\t";
			}
			string += "\n";
		}
		deck = temp;
		return string;
	}

	public Card deal() {
		return deck.pop();
	}

	private Stack<Card> reverse(Stack<Card> cards) {
		Stack<Card> reverse = new Stack<Card>();
		while (!cards.isEmpty())
			reverse.push(cards.pop());
		return reverse;
	}

	public void bridgeShuffle() {
		Stack<Card> topHalf = new Stack<Card>();
		for (int i = 0; i < 26; i++)
			topHalf.push(deck.pop());
		topHalf = reverse(topHalf);

		Stack<Card> newDeck = new Stack<Card>();

		while (!topHalf.isEmpty()) {
			newDeck.push(topHalf.pop());
			newDeck.push(deck.pop());
		}
	
		deck = reverse(newDeck);
	}

	public void cut() {
		int spot = (int) (Math.random() * (deck.size() - 1)) + 1;

		Stack<Card> newDeck = new Stack<Card>();
		for (int i = 0; i < spot; i++)
			newDeck.push(deck.pop());
		newDeck = reverse(newDeck);
		deck = reverse(deck);
		while (!deck.isEmpty())
			newDeck.push(deck.pop());
		deck = newDeck;
	}
	
	public void completeShuffle(){
		for(int i = 0; i < 7; i++){
			bridgeShuffle();
			cut();
		}
	}
}
