/*
����ڿ��� ������ �� n�� �Է¹޾� 1~n������ 3�� �����
�հ� 3�� ����� ������ ���Ͽ� ����Ͻÿ�.
*/
import java.util.*;
class  ForPrac4
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �� n�� �Է��Ͻÿ�==> ");
		int n = sc.nextInt();
		int sum = 0;
		int count = 0;
		
		for (int i = 1; i<=n ;i++ )
		{
			if(i%3==0)
			{	
				sum = sum + i;
				count++
				
				
			}
		}
		System.out.println("n�� 3�� ����� ����"+sum+"�̰� ������ "+count+"�̴�" );
	}
}