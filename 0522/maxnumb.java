/*
연습) 사용자에게 두개의 정수를 입력받아 그중에 큰수를 찾아
출력하는 프로그램을 작성.(단, 삼항연산자를 이용할 것)
*/
import java.util.*;
class  maxnumb
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수==> ");
		int a = sc.nextInt();
		System.out.print("두번째 정수==> ");
		int b = sc.nextInt();

		int c = (a>b)?a:b;
		System.out.println(c);
	}
}
