/*사용자에게 n을 입력받아 n!을 구하라*/
import java.util.*;
class ForPrac6
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n을 입력하시오==> ");
		int n = sc.nextInt();
		int facto=1;
		int i;
		for (i=n; i>0; i--)
		{
				if (i>1)
					System.out.print(i+"*");
				else
					System.out.print(i+"=");
			facto = facto*i;	
		}
		
		System.out.println(facto);
	}
}

	//facto = facto*i;