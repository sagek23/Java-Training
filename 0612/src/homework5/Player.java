package homework5;

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
	
	public int twoPair()
	{
		int a = 0;
		for(int i=0;i<list.size();i++)
		{
			for (int j=i+1;j<list.size();j++)
			{

				if(list.get(i).number.equals(list.get(j).number))
				{
					switch(list.get(i).number)
					{
					case "Jack":a=11;break;
					case "Queen":a=12;break;
					case "King":a=13;break;
					case "Ace":a=14;break;
					default :a = Integer.parseInt(list.get(j).number);
					}
					//a = Integer.parseInt(list.get(i).number);
					return a;
				}
			}
		}
		return a;
	}
	public int twoPair1()
	{
		int b = 0;
		for(int k=0;k<list.size();k++)
		{
			for (int l=k+1;l<list.size();l++)
			{

				if(list.get(k).number.equals(list.get(l).number))
				{
					switch(list.get(k).number)
					{
					case "Jack":b=11;break;
					case "Queen":b=12;break;
					case "King":b=13;break;
					case "Ace":b=14;break;
					default :b = Integer.parseInt(list.get(l).number);
					}
					//b = Integer.parseInt(list.get(k).number);
					return b;
				}
			}	
		}
		return b;
	}
}		












