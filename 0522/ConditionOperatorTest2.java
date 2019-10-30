/* 사용자로부터 임의의 정수를 입력받아
   만약 그 수가 0보다 크거나 같으면 그 수에 더하기 100을 하여
   출력하고 그렇지 않으면 그수의 제곱을 출력하는 프로그램*/
import java.util.*;
class ConditionOperatorTest2 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("임의의 정수 n을 입력해주세요==> ");
		int n = sc.nextInt();
		int r;
		r = (n>=0)?n+100:n*n;
		System.out.println(r);
	}	
}
