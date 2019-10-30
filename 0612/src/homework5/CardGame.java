package homework5;

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
		int p1Score=p1.twoPair();
		int p2Score=p2.twoPair();
		int p1Score1=p1.twoPair1();
		int p2Score2=p2.twoPair1();
		
	
		
		if (p1Score>p2Score&&p1Score1>p2Score2)
		{
			System.out.println("p1 win");
		}
		else if (p2Score>p1Score&&p2Score2>p1Score1)
		{
			System.out.println("p2 win");
		}
		else
		{
			System.out.println("draw");
		}
	}
}










