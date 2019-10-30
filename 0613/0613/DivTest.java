/*프로그램 실행시 두개의 정수를 전달받아 나누기한 결과를 출력하는 프로그램
ex) java DivTest 10 5 
*/
import java.util.*;
class  DivTest
{
	public static void main(String[] args) 
	{
		try{
		Scanner sc = new Scanner(System.in);
		int a, b, r;
		a = Integer.parseInt(args[0]);
		b = Integer.parseInt(args[1]);
		r=a/b;
		System.out.println("결과: "+r);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("나눗셈에 필요한 두수를 전달하시오");
		}catch(NumberFormatException e)
		{System.out.println("숫자만 입력가능");}
		catch(ArithmeticException e)
		{System.out.println("1이상의 수만 입력가능");}
	}
}
