/*
����ڿ��� n�� �Է¹޾� 1~n������ ���� �����Ͽ� ����ϴ� ���α׷�
*/
import java.util.*;
class  SumTest
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n�� �Է��ϼ���==> ");
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 1; i<=n ;i++ )
		{
			sum += i;
		}
		System.out.println("1����"+n+"������ �� "+sum);
	}
}