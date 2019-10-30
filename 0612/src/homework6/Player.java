package homework6;

import java.util.ArrayList;

public class Player {
	ArrayList<Card> list = new ArrayList<Card>();
	ArrayList<String> al = new ArrayList<String>();
	public void showCards()
	{
		System.out.println(list);
	}
	
	public void getCard(Card card)
	{
		list.add(card);
	}
	int u=0;
	String f="";
	public int flush()
	{
		for(int i=0;i<list.size();i++)
		{
			for (int j=i+1;j<list.size();j++)
			{
				for(int k=j+1;k<list.size();k++)
				{
					for(int l=k+1;l<list.size();l++)
					{	
						if(list.get(i).suit.equals(list.get(j).suit)&&list.get(i).suit.equals(list.get(k).suit)&&
								list.get(i).suit.equals(list.get(l).suit))
								switch(list.get(i).suit)
								{
								case "Spades":u=100;break;
								case "Diamonds":u=90;break;
								case "Hearts":u=80;break;
								case "Clubs":u=70;break;
								default :u = Integer.parseInt(list.get(j).suit);
								}
								return u;
					}
				}
			}
		}
		return u;
	}

}		












