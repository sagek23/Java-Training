/*
사용자에게 n을 입력받아 1~n까지의 합을 누적하여 출력
*/
import java.util.*;
class  WhileSum
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n을 입력==> ");
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

