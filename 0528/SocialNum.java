//사용자에게 주민번호를 입력받아 성별을 판별하라
import java.util.*;
class  SocialNum
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하시오==> ");
		String num = sc.next();
		//String w = "2";
		//String ww = "4";
		String a = num.charAt(7)+"";

		//System.out.println(a);
		if (a.equals("2") || a.equals("4"))
			System.out.println("여자");
		else if (a.equals("1") || a.equals("3"))
			System.out.println("남자");
		else
			System.out.println("잘못입력하였습니다.");
	}
}
