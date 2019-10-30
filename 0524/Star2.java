/*
다음과 같이 동작하는 프로그램 작성
별을 몇줄 출력할까요? 3
별을 몇칸 출력할까요? 4
****
****
****
*/
import java.util.*;
class  Star2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("별을 몇줄 출력할까?==> ");
		int a = sc.nextInt();
		System.out.print("별을 몇칸 출력할까?==> ");
		int b = sc.nextInt();
		
		for (int i=1;i<=a ;i++ )
		{
			for (int j=1;j<=b ;j++ )
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}
}
