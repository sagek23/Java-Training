/*
연습) 사용자에게 태어난 월(month)을 입력받아
계절명을 출력하는 프로그램을 작성.
*/
import java.util.*;
class  bmonth1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("몇월에 태어났나요?==> ");
		int month = sc.nextInt();
		String bmonth = "";
		if (month <1 || month>12)
			System.out.println("1~12사이의 숫자를 입력해주세요");
		else
		{

			if (3<=month && month<=5)
				bmonth = "봄";
		else if (6<=month && month<=8)
				bmonth = "여름";
		else if (9<=month && month<=11)
				bmonth = "가을";
		else
			bmonth = "겨울";
			System.out.println(bmonth+"에 태어났네요");
		}	
	}
}
