/*

����1) ����� ���� N�� �Է¹޾� �� ���� �Ҽ����� �Ǻ��ϴ� 
���α׷��� �����ڷ� ���� �ڵ��� �����ϵ��� �����մϴ�.
*/
import java.util.*;
class  HW1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("n�� �Է��ϼ���");
		int n = sc.nextInt();
		
		int i = 1;
		int count = 0;
		while (i<=n)
		{
			if (n%i==0)
				count+=1;
			i++;
		}
		if (count!=2)
					System.out.println("�Ҽ��� �ƴմϴ�");
				else
					System.out.println("�Ҽ��Դϴ�");
	}
}
