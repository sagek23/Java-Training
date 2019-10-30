/*1. 간단한 계산기 프로그램을 작성. 먼저 사용자로부터 하나의 문자를 입력받음.
이어서 사용자로부터 2개의 숫자를 입력받음. 사용자로부터 입력받은 문자가 '+'
이면 두 수의 덧셈, 문자가'-'이면 뺄셈, 문자가'X'이면 곱셈, 문자가 '/'이면
나눗셈을 수행. if-else문 사용. 나눗셈의 경우, 분모가 0이 아닌지 검사*/
import java.util.*;
class  HW3
{
	public static void main(String[] args) 
	{	
		Scanner sc = new Scanner(System.in);
		System.out.print("+, -, X, / 중 하나를 입력하시오==> ");
		String cal = sc.next();
		System.out.print("첫번째 수==>");
		int a = sc.nextInt();
		System.out.print("두번째 수==>");
		int b = sc.nextInt();
		int result = 0;

		if (cal.equals("+"))
			result=a + b;
		else if (cal.equals("-"))
			result=a - b;
		else if (cal.equals("X"))
			result=a * b;
		else if (cal.equals("/"))
			if(b==0)
				System.out.println("0 이외의 수를 입력하시오");
			while (true)
				{
					System.out.print("두번째 수==>");
					b = sc.nextInt();
					if(b!=0)
						break;
				}
			result=a / b;

			
		System.out.println(result);
		
	



	}
}
