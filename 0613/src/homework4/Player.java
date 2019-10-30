package homework4;

import java.util.ArrayList;

public class Player {
	ArrayList<Card> list = new ArrayList<Card>();
	String type ="";
	int score;
	
	
	public void showCards()
	{
		System.out.println(list);
	}
	
	public void getCard(Card card)
	{
		list.add(card);
	}	
	int r =0;
	public int twoPair()
	{
		
		//가지고 있는 카드가 원페어인지 검사하고
		//그것을 제외한 카드 중에 또 원페어가 있는지 검사.
		//두명이 모두 투페어이면 투페어인 카드 중에 큰값을 반환
		int no1= onePair();
		int no2=0;
		if(no1!=0)
		{
			//갖고 있는 배열에서 no1의 카드를 제거하고 검사 
			//또는 갖고있는 모든 카드들 중에 숫자가 no1이 아니고 같은 카드가 있는지 검사
			no2=onePair();
			if(no2!=0 && no2!=no1)
			{
				r = no1;
				if(no2>r)
					r=no2;
				type = "투페어";
				score =r*10; //10은 임의의 수. 곱하는 이유는 큰 수를 확실히하기 위해
			}
		}
		return r;
	}
	public int onePair()
	{
		int r = 0;
		for(int i=0;i<list.size();i++)
		{
			for (int j=i+1;j<list.size();j++)
			{
				if(list.get(i).number.equals(list.get(j).number))
				{
					switch(list.get(i).number)
					{
					case "Jack":r=11;break;
					case "Queen":r=12;break;
					case "King":r=13;break;
					case "Ace":r=14;break;
					default :r = Integer.parseInt(list.get(j).number);
					}
					list.remove(i);
					list.remove(j);
					type="OnePair";
					score=r;
					return r;
				}
			}
		}
		return r;
	}
}











