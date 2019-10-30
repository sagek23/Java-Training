import java.util.*;
class  DoWhile4
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n을 입력하시오==> ");
		int n = sc.nextInt();
		int facto = 1;
		
		do
		{	
			facto *= n;
			if (n>1)
				System.out.print(n+"*");
			else if(n==1)
				System.out.print(n);
			n--;
		}
		while (n>=1);
		System.out.println("="+facto);
	}
}
