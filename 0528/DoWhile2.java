import java.util.*;
class DoWhile2 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("임의의 수 n을 입력하시오==> ");
		int n = sc.nextInt();

		int sum = 0;
		int i=1;
		do
		{
			sum+=i;
			i++;
		}
		while (i<=n);
		System.out.println(sum);
	}
}
