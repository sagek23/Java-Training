/*
연습) 사용자의 이름, 생월, 생일을 입력받아 별자리를 판별하여 출력하는
프로그램을 작성하시오
*/
import java.util.*;
class  Constellation3
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요==> ");
		String name = sc.next();
		System.out.print("생월을 입력하세요==> ");
		int month = sc.nextInt();
		System.out.print("생일을 입력하세요==> ");
		int day = sc.nextInt();
		String star ="";
		int lastday = 31;

		if (month<0 || month>13)
		{
			System.out.println("생월이 잘못되었습니다");		
			return;//if문을 끝냄
		}
		

		if (month ==2)
			lastday = 28;
		else if (month==4 || month==6 || month==9 || month==11)
			lastday=30;
				
				
		if (day<0 || day>lastday)
		{
			System.out.println("생일이 잘못되었습니다");		
			return;//if문을 끝냄
		}
		
			
	
		switch (month)
		{
		case 1: 
			if (day<20)
				star = "염소자리";
			else
				star = "물병자리";
			break;
		case 2:
			if (day<20)
				star = "물병자리";
			else
				star = "물고기자리";
			break;
		case 3: 
			if (day<20)
				star = "물고기자리";
			else
				star = "양자리";
			break;
		case 4:
			if (day<20)
				star = "양자리";
			else
				star = "황소자리";
			break;
		case 5:
			if (day<21)
				star = "황소자리";
			else
				star = "쌍둥이자리";
			break;
		case 6:
			if (day<22)
				star = "쌍둥이자리";
			else
				star = "게자리";
			break;
		case 7:
			if (day<23)
				star = "게자리";
			else
				star = "사자자리";
			break;
		case 8:
			if (day<23)
				star = "사자자리";
			else
				star = "처녀자리";
			break;
		case 9:
			if (day<24)
				star = "처녀자리";
			else
				star = "천칭자리";
			break;
		case 10:
			if (day<23)
				star = "천칭자리";
			else
				star = "전갈자리";
			break;
		case 11:
			if (day<23)
				star = "전갈자리";
			else
				star = "사수자리";
			break;
		case 12:
			if(day<25)
				star = "사수자리";
			else
				star = "염소자리";
			break;
		
			
		}
		System.out.println(name +"님의 별자리는 " + star +"입니다");
	}
}

