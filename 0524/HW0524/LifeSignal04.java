
import java.util.Scanner;
class LifeSignal04 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String name,r1="", 
			r3="귀액권파인문복고역간수명", 
			fResult ="";
		//배열: 자료형이 같은 기억장소의 모임
		String []yearSign= {"쥐","소","범","토끼","용","뱀","말","양","원숭이","닭","개","돼지"};
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
		String r2="천";
		int month, day, hour,num=0, 
			numY=0, numM=0, numD=0, numH;		

		System.out.println("이름을 입력하세요: ");
		name = sc.next();
		System.out.println("띠를 입력하세요: ");
		System.out.println("0:쥐, 1:소, 2:범 3:토끼 4:용 5:뱀 6:말 7:양 8:원숭이 9:닭 10:개 11:돼지  ==>");
		num = sc.nextInt();
		System.out.println("생월을 입력하세요: ");
		month = sc.nextInt();
		System.out.println("생일을 입력하세요: ");
		day = sc.nextInt();
		System.out.println("생시를 입력하세요: ");
		System.out.println("0:자, 1:축, 2:인 3:묘 4:진 5:사 6:오 7:미 8:신 9:유 10:술 11:해  ==>");
		hour = sc.nextInt();

		System.out.println("입력하신 정보는 다음과 같습니다.");
		System.out.println(name+" 님 : "+yearSign[num]+"띠, "+month+"월, "+day+"일, "+hour+"시");
		
		r1 = r2+ r3.charAt(num) +"";		
		System.out.print(r1+": ");
		System.out.println(detail[num]);
		numM = month-1 + num;
		if(numM >= 12)
			//numM = numM - 12;
			numM = numM % 12;
		System.out.print(r2  + r3.charAt(numM)+": ");
		System.out.println(detail[numM]);

		numD = day-1 + numM;
		if(numD >= 12)
			//numD = numD - 12;
			numD = numD % 12;

		System.out.print(r2  + r3.charAt(numD)+": ");
		System.out.println(detail[numD]);

		numH = hour-1+ numD;
		if(numH >= 12)
//			numH = numH - 12;
			numH = numH % 12;
		System.out.print(r2  + r3.charAt(numH)+": ");
		System.out.println(detail[numH]);
	}
}
