/*
숙제1) 사용자 한테 N을 입력받아 
	1에서 n까지의 합을 누적하여 출력하는 프로그램을 
	참고자료 없이 상태로 연습합니다.
	(내일 손코딩 시험 봅니다.)
*/
import java.util.*;
class  Homework1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n을 입력하시오==> ");
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 1; i<=n ; i++)
		{
			sum += i;
		}
		
		System.out.println("1에서 "+n+"까지의 합은 "+sum);
	}	
}
