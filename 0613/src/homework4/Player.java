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
		
		//������ �ִ� ī�尡 ��������� �˻��ϰ�
		//�װ��� ������ ī�� �߿� �� ���� �ִ��� �˻�.
		//�θ��� ��� ������̸� ������� ī�� �߿� ū���� ��ȯ
		int no1= onePair();
		int no2=0;
		if(no1!=0)
		{
			//���� �ִ� �迭���� no1�� ī�带 �����ϰ� �˻� 
			//�Ǵ� �����ִ� ��� ī��� �߿� ���ڰ� no1�� �ƴϰ� ���� ī�尡 �ִ��� �˻�
			no2=onePair();
			if(no2!=0 && no2!=no1)
			{
				r = no1;
				if(no2>r)
					r=no2;
				type = "�����";
				score =r*10; //10�� ������ ��. ���ϴ� ������ ū ���� Ȯ�����ϱ� ����
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











