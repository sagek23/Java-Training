/*사용자한테 문장을 입력받아 
	대문자 A의 수를 구하여 출력해 봅니다.*/
import java.util.*;
class  UpperA
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		

		System.out.println("영어로 문장을 입력하세요");
		String a;
		
		a = sc.nextLine();
		int n = 0;
		for (int i = 0; i<a.length() ;i++ )
		{	
			char b = a.charAt(i);
			if (b == 'A')
				n = n+1;
		}
		System.out.println("대문자 A의 개수는 "+ n);
	}
}
