/* 연습) 정부에서는 나이가 40세 이상이고 홀수년도에 태어난 사람들에게 
무료암검진을 실시하려고 한다. 환자의 이름과 출생년도를 입력받아 무료
암검진 대상자인지 판별하여 출력하는 프로그램을 작성하라*/
import java.util.*;
class  CancerCheck
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Date today = new Date();
		String name;
		int byear;
		int tyear;
		tyear = today.getYear()+1900;
		System.out.println("**고객정보 입력**");
		System.out.print("이름을 입력하세요 ==> ");
		name = sc.next();
		System.out.print("출생년도를 입력하세요 ==> ");
		byear = sc.nextInt();

		if (byear%2!=0 && tyear - byear >= 40)
			System.out.println("무료 암검진 대상입니다");
		else
			System.out.println("무료 암검진 대상이 아닙니다");
	}
}
