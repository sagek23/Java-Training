/* 사용자에게 0~99사이의 정수를 입력받아 
한글표기식 출력하는 프로그램을 작성합니다.
         (단, if문을 100개를 사용하는 것은 아닙니다^^)*/
import java.util.*;
class Homework2 
{
	public static void main(String[]args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("0~99사이의 숫자를 입력하세요==> ");
		int a = sc.nextInt();
		String r = "";
		String s = "";
		
		if(a<0 || a>100)
		{
			System.out.println("숫자를 다시 입력하세요");
			return;
		}		

		if (a>=10 && a<20)
			s= "십";
		else if (a>=20 && a<30)
			s= "이십";
		else if (a>=30 && a<40)
			s= "삼십";
		else if (a>=40 && a<50)
			s= "사십";
		else if (a>=50 && a<60)
			s= "오십";
		else if (a>=60 && a<70)
			s= "육십";
		else if (a>=70 && a<80)
			s= "칠십";
		else if (a>=80 && a<90)
			s= "팔십";
		else if (a>=90 && a<100)
			s= "구십";

			
		
		if (a==0)
			r = "영";
		else if (a%10==1)
			r = "일";
		else if (a%10==2)
			r = "이";
		else if (a%10==3)
			r = "삼";
		else if (a%10==4)
			r = "사";
		else if (a%10==5)
			r = "오";
		else if (a%10==6)
			r = "육";
		else if (a%10==7)
			r = "칠";
		else if (a%10==8)
			r = "팔";
		else if (a%10==9)
			r = "구";
		
		System.out.println(s+r);


	}
}

