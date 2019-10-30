/*사용자로 부터 두 개의 정수를 입력받아 그중에 큰수를 찾아 
출력하는 프로그램을 참고자료 없이 손코딩이 가능하도록 연습합니다.*/
import java.util.*;
class minnum
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		int min;
		System.out.print("첫번째 수 ==>");
		int a = sc.nextInt();
		System.out.print("두번째 수 ==>");
		int b = sc.nextInt();

		if (a<b)
			min = a;
			
		else
			min = b;
		System.out.println(min);

	}
}