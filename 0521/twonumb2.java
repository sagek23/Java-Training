/* ����ڿ��� �ΰ��� ������ �Է¹޾� �� �� ū���� ã�� ����ϴ� ���α׷��� �ۼ��϶�*/
import java.util.*;
class twonumb2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int a, b, max;
		System.out.print("ù��° �� �Է� ==> ");
		a = sc.nextInt();
		System.out.print("�ι�° �� �Է� ==> ");
		b = sc.nextInt();
		
		if (a>b)
			max = a;
		else
			max = b;

		System.out.print("��� ==> "+max);

	}
}