/*연습)
고객의 이름, 주소, 나이, 키, 전화번호를 입력받아 출력하는
프로그램 작성
(단, 주소는 공백없이 입력받도록 한다)*/
import java.util.*;
class customer
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String a,b,e;
		int c;
		double d;
		
		System.out.println("고객님의 이름을 입력하여 주십시오");
		a = sc.next();
		System.out.println("주소를 공백없이 입력하여 주십시오");
		b = sc.next();
		System.out.println("나이를 입력하여 주십시오");
		c = sc.nextInt();
		System.out.println("키를 입력하여 주십시오");
		d = sc.nextDouble();
		System.out.println("전화번호를 -없이 입력하여 주십시오");
		e = sc.next();
		
		System.out.println("**고객정보**");
		System.out.println("이름: " + a );
		System.out.println("주소: " + b );
		System.out.println("나이: " + c );
		System.out.println("키: " + d +"cm");
		System.out.println("전화번호: " + e);
	}
}
