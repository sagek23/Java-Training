import java.util.*;
class Star 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n을 입력하시오==> ");
		int n = sc.nextInt();
		for (int i=1;i<=n ;i++ )
		{
			int j = 1;
			do
			{
				System.out.print("*");
				j++;
			}
			while (j<=i);
			System.out.println();
		}
	}
}
