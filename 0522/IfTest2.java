/*
연습) 사용자에게 세개의 정수를 입력받아 그중 가장 큰수를 찾아 출력하는
프로그램 작성. (중첩if명을 사용할 것)
*/
import java.util.*;
class IfTest2 
{
	public static void main(String[] args) 
	{	
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수==> ");
		int a = sc.nextInt();
		System.out.print("두번째 수==> ");
		int b = sc.nextInt();
		System.out.print("세번째 수==> ");
		int c = sc.nextInt();

		if (a>b)
			if(a>c)
				System.out.println(a);
		if(b>c)
			if(b>a)
				System.out.println(b);
		if(c>a)
			if(c>b)
				System.out.println(c);
		


	}
}
