
/*����ڷκ��� 3���� ������ �Է¹޾� if-else���� ����Ͽ� ���� ���� ���� �����ϴ�
���α׷��� �ۼ�*/
import java.util.*;
class  Mini
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
		int min;
		if (a<b)
			if(a<c)
				min = a;
			else
				min = c;
		else
			if(b<c)
				min = b;
			else
				min = c;
		System.out.println(min);		
	}
}
