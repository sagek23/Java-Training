/* ����ڿ��� 0~99������ ������ �Է¹޾� 
�ѱ�ǥ��� ����ϴ� ���α׷��� �ۼ��մϴ�.
         (��, if���� 100���� ����ϴ� ���� �ƴմϴ�^^)*/
import java.util.*;
class Homework2 
{
	public static void main(String[]args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("0~99������ ���ڸ� �Է��ϼ���==> ");
		int a = sc.nextInt();
		String r = "";
		String s = "";
		
		if(a<0 || a>100)
		{
			System.out.println("���ڸ� �ٽ� �Է��ϼ���");
			return;
		}		

		if (a>=10 && a<20)
			s= "��";
		else if (a>=20 && a<30)
			s= "�̽�";
		else if (a>=30 && a<40)
			s= "���";
		else if (a>=40 && a<50)
			s= "���";
		else if (a>=50 && a<60)
			s= "����";
		else if (a>=60 && a<70)
			s= "����";
		else if (a>=70 && a<80)
			s= "ĥ��";
		else if (a>=80 && a<90)
			s= "�Ƚ�";
		else if (a>=90 && a<100)
			s= "����";

			
		
		if (a==0)
			r = "��";
		else if (a%10==1)
			r = "��";
		else if (a%10==2)
			r = "��";
		else if (a%10==3)
			r = "��";
		else if (a%10==4)
			r = "��";
		else if (a%10==5)
			r = "��";
		else if (a%10==6)
			r = "��";
		else if (a%10==7)
			r = "ĥ";
		else if (a%10==8)
			r = "��";
		else if (a%10==9)
			r = "��";
		
		System.out.println(s+r);


	}
}
