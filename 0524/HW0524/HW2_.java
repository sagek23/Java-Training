/*
����2) ������� �̸�, ��, ����, ����, ���ø� �Է¹޾� 
"��������"�� �Ǻ��Ͽ� ����ϴ� ���α׷��� �ۼ��ϼ���.
*/
import java.util.*;
class  HW2_
{
	public static void main(String[] args) 
	{	
		String a="";
		int []lastDay={31,28,31,30,31,30,31,31,20,31,30,31};
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.print("�̸��� �Է��ϼ���==> ");
			String name = sc.next();
			System.out.println("�츦 �Է��ϼ���(��ȣ��)");
			System.out.println("0.�� 1.�� 2.�� 3.�䳢 4.�� 5.�� 6.�� 7.�� 8.������ 9.�� 10.�� 11.���� ");
			System.out.print("���� ��ȣ�� �Է��ϼ���==>  ");
			int animal, bmonth, bday, bhour;
			while (true)
			{
				animal = sc.nextInt();
				if (animal>=0 && animal<12)
				break;
				else
					System.out.print("�ٽ� �Է��ϼ���==>");
			}
			System.out.print("������ �Է��ϼ���==> ");
			while (true)
			{
				bmonth = sc.nextInt();
				if (bmonth>0 && bmonth<13)
				break;
				else
					System.out.print("�ٽ� �Է��ϼ���==>");
			}
			System.out.print("������ �Է��ϼ���==> ");
			while (true)
			{
				bday = sc.nextInt();
				if (bday>0 && bday<=lastDay[bmonth-1])
				break;
				else
					System.out.print("�ٽ� �Է��ϼ���==>");
			}
			System.out.println("0:��, 1:��, 2:�� 3:�� 4:�� 5:�� 6:�� 7:�� 8:�� 9:�� 10:�� 11:��  ==>");
			while (true)
			{
				bhour = sc.nextInt();
				if (bhour>=0 && bhour<12)
				break;
				else
					System.out.print("�ٽ� �Է��ϼ���==>");
			}
			
			String []saju = {"õ��","õ��","õ��","õ��","õ��","õ��","õ��","õ��","õ��","õ��","õ��","õ��"};
			/*
			String []detail = {
				"��� ������ ���δ����� �޾ƿ�", //��
				"�ܺ�ġ���� ������ ����", //��
				"�������� �ִ� ���", //��
				"�ؿܷ� �� ���� ����", //��
				"�ΰ����� ����", //��
				"�Ӹ��� ����", //��
				"�ϴ÷κ��� ���� ����", //��
				"�ܷο��� ���� Ž", //��
				"�پ��� ��鿡 ������ ����", //��
				"����ں��� ����", //��
				"�����ְ� ����", //��
				"���� ��." //��
			};
			*/
			int count = 0;

			String str="";
			if (animal==0)
			{	str = "õ��";
				count = 0;
			}
			else if (animal==1)
			{
				str = "õ��";
				count = 1;
			}
			else if (animal==2)
			{	str = "õ��";
				count = 2;}
			else if (animal==3)
			{	str = "õ��";
				count = 3; }
			else if (animal==4)
			{	str = "õ��";
				count = 4; }
			else if (animal==5)
			{	str = "õ��";
				count = 5; }
			else if (animal==6)
			{	str = "õ��";
				count = 6; }
			else if (animal==7)
			{	str = "õ��";
				count = 7; }
			else if (animal==8)
			{	str = "õ��";
				count = 8; }
			else if (animal==9)
			{	str = "õ��";
				count = 9; }
			else if (animal==10)
			{	str = "õ��";
				count = 10; }
			else if (animal==11)
			{	str = "õ��";
				count = 11; }
				
			int month=0;
			int day=0;
			int hour=0;

			month = bmonth-1+count;
			if(month>=12)
				month= month%12;

			day = bday-1+month;
			if(day>=12)
				day = day%12;
			hour = bhour+day;
			if(hour>=12)
				hour = hour%12;
			System.out.println(str);
			System.out.println(saju[month]);
			System.out.println(saju[day]);
			System.out.println(saju[hour]);
			
			while(true)
			{
				System.out.println("�ٽ� �Ͻðڽ��ϱ�?(y/n)");
				a = sc.next();
				if(a.equals("y") || a.equals("n"))
					break;
			}
			
			if(a.equals("n"))
				System.out.println("�����մϴ�");
				break;
		}
		
	}
		
}