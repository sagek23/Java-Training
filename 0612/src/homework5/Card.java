package homework5;

public class Card {
	String suit;		//����
	String number;		//����
	public Card(String suit, String number) {
		super();
		this.suit = suit;
		this.number = number;
	}
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Card [suit=" + suit + ", number=" + number + "]";
	}
	
	
}
