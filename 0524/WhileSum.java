/*
����ڿ��� n�� �Է¹޾� 1~n������ ���� �����Ͽ� ���
*/
import java.util.*;
class  WhileSum
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n�� �Է�==> ");
		int n = sc.nextInt();
		int sum = 0;

		int i = 1;
		while(i <= n)
		{	
			sum+=i;
			i++;
		}
		System.out.println(sum);

	}
}
