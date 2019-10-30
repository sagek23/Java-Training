/*다음과 같이 정의되는 함수의 함수값을 계산하여 보자. 사용자로부터 x값을 입력
받아서 함수값을 계산하여 화면에 출력한다. x는 실수이다*/

import java.util.*;
class  FunctionX
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("실수 x의 값을 입력하시오==> ");
		double x = sc.nextDouble();
		double result = 0;
		if (x<=0)
			result = (x*x*x)-(9*x)+2;
		else
			result = (7*x) +2;
		
		System.out.println("결과:"+ result);
	}
}
