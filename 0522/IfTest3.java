/*
����) ����ڿ��� ������ ������ �Է¹޾� ���� ���� ū���� ã�� ����ϴ�
���α׷� �ۼ�. (��øif���� ����� ��)
*/
import java.util.*;
class IfTest3 
{
	public static void main(String[] args) 
	{	
		Scanner sc = new Scanner(System.in);
		int max;
		System.out.print("ù��° ��==> ");
		int a = sc.nextInt();
		System.out.print("�ι�° ��==> ");
		int b = sc.nextInt();
		System.out.print("����° ��==> ");
		int c = sc.nextInt();
		

		if (a>b)
			if(a>c)
				max = a;
			else
				max = c;
		else
			if(b>c)
				max = b;
			else
				max = c;
	
		System.out.println(max);
		


	}
}
