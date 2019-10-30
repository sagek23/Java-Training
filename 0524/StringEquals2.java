/*사용자에게 암호와 암호확인을 입력받아
서로 같은 값인지 판별*/
import java.util.*;
class  StringEquals2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String password, check;
		System.out.println("암호를 입력하시오");
		password = sc.next();
		System.out.println("암호확인을 입력하시오");
		check = sc.next();

		//if(name == "tiger")
		if(password.equals(check))
			System.out.println("일치합니다");
		else
			System.out.println("일치하지않습니다");
	}
}
