/*
사용자에게 월을 입력받아 계절명을 출력하라
switch문을 사용할 것
*/
import java.util.*;
class  Season
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력하세요==> ");
		int month = sc.nextInt();
		String season="";
		

		switch (month)
		{
			case 12: case 1: case 2:
				season = "겨울";
				break;
			case 3:
			case 4:		
			case 5:
				season ="봄";
				break;			
			case 6:
			case 7:
			case 8:
				season ="여름";
				break;
			case 9:
			case 10:
			case 11:
				season = "가을";
				break;
			default: //== if문의 else
				season = "잘못된 값 입니다";
		}
		System.out.println(season);
	}
}

/*case문 안에 if문이 올 수 있음*/
