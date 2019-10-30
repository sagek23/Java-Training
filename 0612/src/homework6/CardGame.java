package homework6;

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
		int p1S=p1.flush();
		int p2S=p2.flush();
		
		
		if (p1S>p2S)
		{
			System.out.println("p1 win");
		}
		else if (p2S>p1S)
		{
			System.out.println("p2 win");
		}
		else
		{
			System.out.println("draw");
		}
	
		
	}
}










