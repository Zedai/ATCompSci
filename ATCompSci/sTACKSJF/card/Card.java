package card;

public class Card implements Comparable<Card>{
	private int suit, value;
	
	public Card(){
		this.suit = 1;
		this.value = 2;
	}

	public Card(int suit, int value){
		if(value < 2 || value > 14 || suit < 1 || suit > 4)
			throw new IllegalArgumentException();
		this.suit = suit;
		this.value = value;
	}
	
	public String toString(){
		String string = "";
		
		switch(value){
			case 2:{
				string += "2 of ";
				break;
			}
			case 3:{
				string += "3 of ";
				break;
			}
			case 4:{
				string += "4 of ";
				break;
			}
			case 5:{
				string += "5 of ";
				break;
			}
			case 6:{
				string += "6 of ";
				break;
			}
			case 7:{
				string += "7 of ";
				break;
			}
			case 8:{
				string += "8 of ";
				break;
			}
			case 9:{
				string += "9 of ";
				break;
			}
			case 10:{
				string += "10 of ";
				break;
			}
			case 11:{
				string += "J of ";
				break;
			}
			case 12:{
				string += "Q of ";
				break;
			}
			case 13:{
				string += "K of ";
				break;
			}
			case 14:{
				string += "A of ";
				break;
			}
			default:
				string += "Error of ";	
		}
		
		switch(suit){
			case 1:{
				string += "Clubs";
				break;
			}
			case 2:{
				string += "Diamonds";
				break;
			}
			case 3:{
				string += "Hearts";
				break;
			}
			case 4:{
				string += "Spades";
				break;
			}
			default:
				string += "Error";
		}
		
		return string;
	}

	@Override
	public int compareTo(Card arg0) {
		return this.value - arg0.value;
	}
}
