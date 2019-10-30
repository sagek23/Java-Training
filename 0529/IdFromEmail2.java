/*
이메이로부터 아이디만 잘라와서 출력
*/
import java.util.*;
class	IdFromEmail2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("이메일을 입력하시오");
		String email = sc.next();
		int n = email.indexOf("@");
		String id = email.substring(0, n);
		System.out.println("당신의 id는 "+id+"입니다");
	}
}
