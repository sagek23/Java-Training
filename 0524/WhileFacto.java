/*
����ڿ��� n�� �Է¹޾� n!�� ���Ͽ� ���
*/
import java.util.*;
class  WhileFacto
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n�� �Է��Ͻÿ�==> ");
		int n = sc.nextInt();
		int i = 1;
		int facto = 1;
		while (i<=n)
		{
			facto *= n; 
			
			if (n!=1)
				System.out.print(n+"*");
			else	
				System.out.print(n+"=");
			n--;

		}
		System.out.print(facto);
		
		
	}	
}
