/*
연습) 사용자에게 임의의 정수 n을 입력받아 n이 0보다 크거나 같으면
그 수에 더하게 100을 한 결과를 출력하고 "작업종료"를 출력한다.
그렇지않으면 그 수에 제곱을 출력하고 "작업종료"를 출력한다
*/
import java.util.*;
class  IfTest1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("임의의 정수를 입력하세요==> ");
		int n = sc.nextInt();

		if (n>=0)
			System.out.println(n+100);
		else
			System.out.println(n*n);
		
		System.out.println("작업종료");

	}
}
