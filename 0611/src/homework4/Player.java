package homework4;

import java.util.ArrayList;

public class Player {
	ArrayList<Card> list = new ArrayList<Card>();
	
	public void showCards()
	{
		System.out.println(list);
	}
	
	public void getCard(Card card)
	{
		list.add(card);
	}	
}











