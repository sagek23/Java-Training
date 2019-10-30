/*
사용자에게 n을 입력받아 n!을 구하여 출력
*/
import java.util.*;
class  WhileFacto
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n을 입력하시오==> ");
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
