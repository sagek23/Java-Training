import java.util.*;
class DoWhile2 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �� n�� �Է��Ͻÿ�==> ");
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
