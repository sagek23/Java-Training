import java.util.*;
class Star 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n�� �Է��Ͻÿ�==> ");
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
