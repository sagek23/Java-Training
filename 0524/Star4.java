/*
다음과 같이 동작하는 프로그램을 작성
n을 입력하시오==>
*
**
***
****
*****
*/
import java.util.*;
class  Star4
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n을 입력==> ");
		int n = sc.nextInt();
		for (int i=1;i<=n ;i++ )
		{
			for (int j=n;j>=i ;j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
