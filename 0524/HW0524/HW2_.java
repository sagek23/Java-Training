/*
숙제2) 사용자의 이름, 띠, 생월, 생일, 생시를 입력받아 
"사주팔자"를 판별하여 출력하는 프로그램을 작성하세요.
*/
import java.util.*;
class  HW2_
{
	public static void main(String[] args) 
	{	
		String a="";
		int []lastDay={31,28,31,30,31,30,31,31,20,31,30,31};
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.print("이름을 입력하세요==> ");
			String name = sc.next();
			System.out.println("띠를 입력하세요(번호로)");
			System.out.println("0.쥐 1.소 2.범 3.토끼 4.용 5.뱀 6.말 7.양 8.원숭이 9.닭 10.개 11.돼지 ");
			System.out.print("띠의 번호를 입력하세요==>  ");
			int animal, bmonth, bday, bhour;
			while (true)
			{
				animal = sc.nextInt();
				if (animal>=0 && animal<12)
				break;
				else
					System.out.print("다시 입력하세요==>");
			}
			System.out.print("생월을 입력하세요==> ");
			while (true)
			{
				bmonth = sc.nextInt();
				if (bmonth>0 && bmonth<13)
				break;
				else
					System.out.print("다시 입력하세요==>");
			}
			System.out.print("생일을 입력하세요==> ");
			while (true)
			{
				bday = sc.nextInt();
				if (bday>0 && bday<=lastDay[bmonth-1])
				break;
				else
					System.out.print("다시 입력하세요==>");
			}
			System.out.println("0:자, 1:축, 2:인 3:묘 4:진 5:사 6:오 7:미 8:신 9:유 10:술 11:해  ==>");
			while (true)
			{
				bhour = sc.nextInt();
				if (bhour>=0 && bhour<12)
				break;
				else
					System.out.print("다시 입력하세요==>");
			}
			
			String []saju = {"천귀","천액","천권","천파","천인","천문","천복","천고","천역","천간","천수","천명"};
			/*
			String []detail = {
				"어디를 가던지 귀인대접을 받아요", //자
				"잔병치레가 많으니 조심", //축
				"리더십이 있는 사람", //인
				"해외로 갈 수도 있음", //묘
				"인간성이 좋음", //진
				"머리가 좋음", //사
				"하늘로부터 복을 받음", //오
				"외로움을 많이 탐", //미
				"다양한 방면에 관심이 많음", //신
				"배우자복이 있음", //유
				"손재주가 많음", //술
				"명이 김." //해
			};
			*/
			int count = 0;

			String str="";
			if (animal==0)
			{	str = "천귀";
				count = 0;
			}
			else if (animal==1)
			{
				str = "천액";
				count = 1;
			}
			else if (animal==2)
			{	str = "천권";
				count = 2;}
			else if (animal==3)
			{	str = "천파";
				count = 3; }
			else if (animal==4)
			{	str = "천인";
				count = 4; }
			else if (animal==5)
			{	str = "천문";
				count = 5; }
			else if (animal==6)
			{	str = "천복";
				count = 6; }
			else if (animal==7)
			{	str = "천고";
				count = 7; }
			else if (animal==8)
			{	str = "천역";
				count = 8; }
			else if (animal==9)
			{	str = "천간";
				count = 9; }
			else if (animal==10)
			{	str = "천수";
				count = 10; }
			else if (animal==11)
			{	str = "천명";
				count = 11; }
				
			int month=0;
			int day=0;
			int hour=0;

			month = bmonth-1+count;
			if(month>=12)
				month= month%12;

			day = bday-1+month;
			if(day>=12)
				day = day%12;
			hour = bhour+day;
			if(hour>=12)
				hour = hour%12;
			System.out.println(str);
			System.out.println(saju[month]);
			System.out.println(saju[day]);
			System.out.println(saju[hour]);
			
			while(true)
			{
				System.out.println("다시 하시겠습니까?(y/n)");
				a = sc.next();
				if(a.equals("y") || a.equals("n"))
					break;
			}
			
			if(a.equals("n"))
				System.out.println("종료합니다");
				break;
		}
		
	}
		
}
