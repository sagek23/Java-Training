package homework4;

public class CardGame {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardDeck deck = new CardDeck();
		deck.shuffle();
		
		Player p1 = new Player();
		Player p2 = new Player();
		for (int i=1;i<=5;i++)
		{
			p1.getCard(deck.deal());
			p2.getCard(deck.deal());
		}
		
		p1.showCards();
		p2.showCards();
		p1.twoPair();
		p2.twoPair();
		
		if (p1.score>p2.score)
		{
			System.out.println(p1.type+"p1 win");
		}
		else if (p2.score>p1.score)
		{
			System.out.println(p2.type+"p2 win");
		}
		else
		{
			System.out.println("draw");
		}
	}
}










