/*
다음과 같이 동작하는 프로그램을 작성
<실행예>
별을 몇개나 출력할까요?8
********  
*/
import java.util.*;
class  Star
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("별을 몇개나 출력할까?==> ");
		int n = sc.nextInt();
		for (int i = 1;i<=n ;i++ )
			System.out.print("*");
	
	}
}
