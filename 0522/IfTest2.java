/*
����) ����ڿ��� ������ ������ �Է¹޾� ���� ���� ū���� ã�� ����ϴ�
���α׷� �ۼ�. (��øif���� ����� ��)
*/
import java.util.*;
class IfTest2 
{
	public static void main(String[] args) 
	{	
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ��==> ");
		int a = sc.nextInt();
		System.out.print("�ι�° ��==> ");
		int b = sc.nextInt();
		System.out.print("����° ��==> ");
		int c = sc.nextInt();

		if (a>b)
			if(a>c)
				System.out.println(a);
		if(b>c)
			if(b>a)
				System.out.println(b);
		if(c>a)
			if(c>b)
				System.out.println(c);
		


	}
}