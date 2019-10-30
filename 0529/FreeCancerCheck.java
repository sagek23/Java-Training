/*
사용자에게 주민번호를 입력받아 무료암검진 항목을 출력.
처리조건 - 40세이상 남자이면 위암, 간암
		   40세 이상 여자이면 위암, 간암, 자궁암, 유방암
*/
import java.util.*;
class  FreeCancerCheck
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Date year = new Date();
		int tYear = year.getYear()+1900;
		System.out.println("--무료암검진확인--");
		System.out.print("주민번호를 입력하세요==> ");
		String sNum = sc.next();
		int mm = Integer.parseInt(sNum.charAt(13)+"");
		int sum=0;
		int plus=2;
		int z = 0;
		for (int i = 0;i<sNum.length()-1;i++)
		{
			if (plus==10)
				plus=2;
			if (i==6)
				continue;
			z = Integer.parseInt(sNum.charAt(i)+"");
			sum+=plus*z;
			plus++;
		}
		int right = 11-(sum%11);

		String num = sNum.substring(0,2);//나이를 계산하기위해 년도를 가져옴 ex)91
		String age = "19"+num; //년도앞에 19를 붙임
		int a = Integer.parseInt(age); //문자열 age를 숫자로 변환. 몇년도 생인지 구하는 것
		String gender = sNum.substring(7,8); //-뒤의 첫번째 숫자 하나를 가져옴(성별 판별을 위해)
		int g = Integer.parseInt(gender);  //변수 gender를 숫자로 변환
		

		if (mm==right)
			if (tYear-a>=40 && g==3||g==1)
				System.out.println("위암과 간암 무료검진 대상입니다");
			else if (tYear-a>=40 && g==2||g==4)
				System.out.println("위암, 간암, 자궁암, 유방암 무료검진 대상입니다");
			else
				System.out.println("무료암검진 대상이 아닙니다");
		else
			System.out.println("잘못된 주민번호입니다");
	}
}
