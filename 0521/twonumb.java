/* 사용자에게 두개의 정수를 입력받아 그 중 큰수를 찾아 출력하는 프로그램을 작성하라*/
import java.util.*;
class twonumb
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		System.out.print("첫번째 수 입력 ==> ");
		a = sc.nextInt();
		System.out.print("두번째 수 입력 ==> ");
		b = sc.nextInt();
		if (a>b)
			System.out.println("결과==> "+a);
		else
			System.out.println("결과==> "+b);
	}
}
