
/*사용자로부터 3개의 정수를 입력받아 if-else문을 사용하여 가장 작은 값을 결정하는
프로그램을 작성*/
import java.util.*;
class  Mini
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
		int min;
		if (a<b)
			if(a<c)
				min = a;
			else
				min = c;
		else
			if(b<c)
				min = b;
			else
				min = c;
		System.out.println(min);		
	}
}
