import java.util.*;
class  DoWhile3
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n�� �Է��Ͻÿ�==> ");
		int n = sc.nextInt();
		int facto = 1;
		int i = n;
		do
		{	
			facto *= i;
			if (i>1)
				System.out.print(i+"*");
			else if(i==1)
				System.out.print(i);
			i--;
		}
		while (i>=1);
		System.out.println("="+facto);
	}
}