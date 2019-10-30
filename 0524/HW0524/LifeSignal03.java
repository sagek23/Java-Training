
import java.util.Scanner;
class LifeSignal03 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String name, yearSign="",r1="", 
			r3="귀액권파인문복고역간수명", 
			fResult ="";

		String r2="천";
		int month, day, hour,num=0, 
			numY=0, numM=0, numD=0, numH;		

		System.out.println("이름을 입력하세요: ");
		name = sc.next();
		System.out.println("띠를 입력하세요: ");
		yearSign = sc.next();
		System.out.println("생월을 입력하세요: ");
		month = sc.nextInt();
		System.out.println("생일을 입력하세요: ");
		day = sc.nextInt();
		System.out.println("생시를 입력하세요: ");
		System.out.println("0:자, 1:축, 2:인 3:묘 4:진 5:사 6:오 7:미 8:신 9:유 10:술 11:해  ==>");
		hour = sc.nextInt();

		System.out.println("입력하신 정보는 다음과 같습니다.");
		System.out.println(name+" 님 : "+yearSign+" 띠, "+month+" 월, "+day+" 일, "+hour+" 시");
		
		switch(yearSign){
			case "쥐":r1 ="천귀";num=0;break;
			case "소":r1 ="천액";num=1;break;
			case "호랑이":r1 ="천권";num=2;break;
			case "토끼":r1 ="천파";num=3;break;
			case "용":r1 ="천인";num=4;break;
			case "뱀":r1 ="천문";num=5;break;
			case "말":r1 ="천복";num=6;break;
			case "양":r1 ="천고";num=7;break;
			case "원숭이":r1 ="천연";num=8;break;
			case "닭":r1 ="천간";num=9;break;
			case "개":r1 ="천수";num=10;break;
			case "돼지":r1 ="천명";num=11;break;
		}		
		System.out.println(r1);
		numM = month-1 + num;
		if(numM >= 12)
			//numM = numM - 12;
			numM = numM % 12;
		System.out.println( "" + r2  + r3.charAt(numM));

		numD = day-1 + numM;
		if(numD >= 12)
			//numD = numD - 12;
			numD = numD % 12;

		System.out.println( "" + r2  + r3.charAt(numD));

		numH = hour + numD;
		if(numH >= 12)
//			numH = numH - 12;
			numH = numH % 12;
		System.out.println( "" + r2  + r3.charAt(numH));
	}
}
