/*
����1) ����� ���� N�� �Է¹޾� 
	1���� n������ ���� �����Ͽ� ����ϴ� ���α׷��� 
	�����ڷ� ���� ���·� �����մϴ�.
	(���� ���ڵ� ���� ���ϴ�.)
*/
import java.util.*;
class  Homework1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n�� �Է��Ͻÿ�==> ");
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 1; i<=n ; i++)
		{
			sum += i;
		}
		
		System.out.println("1���� "+n+"������ ���� "+sum);
	}	
}