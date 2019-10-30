/*연습)
고객의 이름, 주소, 나이, 키, 전화번호를 입력받아 출력하는
프로그램 작성
(단, 주소는 공백없이 입력받도록 한다)*/
/*next()는 공뱅이나 리턴키에 의해서 입력이 구분된다.
스페이스를 누르면 입력이 끝난것으로 처리된다. 그러니
공백문자를 포함하여 입력받을 수 없다. 공백문자까지 포험하여
입력하려면 nextLine()을 사용해야한다.next()와 nextLine()은
동작방식이 다르기 떄문에 혼용해서 사용하면 이상하게 동작한다*/

import java.util.*;
class customer2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String a,b,e;
		int c;
		double d;
		
		System.out.println("고객님의 이름을 입력하여 주십시오");
		a = sc.next();
		
		sc.nextLine(); 

		System.out.println("주소를 입력하여 주십시오");
		b = sc.nextLine(); //공백을 넣어서 주소를 입력
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
