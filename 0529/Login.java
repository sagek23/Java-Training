/*
사용자에게 아이디, 암호, 암호확인를 입력받아 올바른회원인지
입력받아 판별하는 프로그램
id - "bitjava" pwd - "javabit"
*/
import java.util.*;
class Login 
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		String myId = "bitjava";
		String myPwd = "javabit";
		System.out.print("id를 입력하세요==> ");
		String id = sc.next();
		if (id.equals(myId))
			System.out.println("id가 확인되었습니다");
		else
			System.out.println("id가 틀렸습니다.");
		System.out.print("암호를 입력하세요==> ");
		String pwd = sc.next();
		if(pwd.equals(myPwd))
			System.out.println("암호가 확인되었습니다");
		else
			System.out.println("암호가 틀렸습니다.");

		System.out.print("암호확인을 입력하세요==> ");
		String pwdChk = sc.next();
		if(pwdChk.equals(pwd))
			System.out.println("올바른 암호입니다");
		else
			System.out.println("암호와 다릅니다");

		if (id.equals(myId)&&pwd.equals(myPwd)&&pwdChk.equals(pwd))
			System.out.println("올바른 회원입니다");
		else
			System.out.println("올바른 회원이 아닙니다");

		
		
	
	//	else
		//	System.out.println("잘못 입력하셨습니다.");
	}
}
