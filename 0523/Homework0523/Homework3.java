/*
����3) ����ڷ� ���� ������ �� N�� �Է¹޾� 
	  �� ���� ����� ������ ���Ͽ� ����մϴ�.
*/
import java.util.*;
class  Homework3
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n�� �Է��Ͻÿ�==> ");
		int n = sc.nextInt();
		int count=0;
		for (int i=1;i<=n ;i++ )
		{
			if (n%i==0)
				count += 1;
		}
		System.out.println(n+"�� ����� ������ "+count+"��");
	}
}