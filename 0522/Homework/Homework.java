/* ����� ���� 0~99������ ������ �Է¹޾� 
		�ѱ�ǥ��� ����ϴ� ���α׷��� �ۼ��մϴ�.
         (��, if���� 100���� ����ϴ� ���� �ƴմϴ�^^)*/
import java.util.*;
class Homework 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("0~99������ ���ڸ� �Է��ϼ���==> ");
		int a = sc.nextInt();
		String b = " ���̻�����ĥ�ȱ�";
		String e = "";
		
		if(a<0 || a>100)
		{
			System.out.println("���ڸ� �ٽ� �Է��ϼ���");
			return;
		}		
		
		//����ڰ� �Է��� ���ڷ� ���� �ڸ� ���� 1�� �ڸ� ���� ���Ѵ�

		int n10 = a/10;
		int n1  = a%10;
		if (a==0)
			e = "��";
		/*else if(a>=10 && a<20)
				e = "��"+b.charAt(n1);*/ 
		else 
		{
			if (n10!=1)
			e = b.charAt(n10)+"";
			
			if(a >=10)
			{
				e = e+"��";
			}
				

			e = e+b.charAt(n1);
		}

		System.out.println(e);



	}
}


/*
char b = a.charAt(i);
			if (b == 'A')
				n = n+1;*/