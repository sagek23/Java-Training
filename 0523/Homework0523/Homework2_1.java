/*����2) ����ڷ� ���� ������ �� N�� �Է¹޾� 
		�� ���� ����� ��� ����մϴ�.*/
import java.util.*;
class  Homework2_1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n�� �Է��Ͻÿ�==> ");
		int n = sc.nextInt();
		for (int i = 1;i<=n ;i++)
		{
			if (n%i==0)
				System.out.print(i);
				if(i!=n)
					System.out.print(",");
	
		}
		
	}
}
