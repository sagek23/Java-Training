/* 사용자에게 임의의 정수를 입력받아 그 수가 짝수인지 홀수인지 판별하여
결과를 출력하는 프로그램을 작성하라*/
import java.util.*;
class  numb
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int a;
		System.out.println("임의의 정수를 입력하시오");
		a = sc.nextInt();
		if (a%2==0)
			System.out.println("짝수입니다");
		else
			System.out.println("홀수입니다");
		
		
	}
}
