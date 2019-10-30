import java.util.*;

class  FreeCancer2
{
	public static void main(String[] args) 
	{ 
		Scanner sc = new Scanner(System.in);
		int a; 
		System.out.println("출생년도를 입력해주세요.");
		a = sc.nextInt();
		Date tyear = new Date(); //현재 설정된 날짜와 시간의 정보를 갖는 객체생성
		int thisyear = tyear.getYear()+1900; 
		//tyear 객체로 부터 현재의 년도를 읽어와 thisyear 변수에 저장
		
		if (thisyear - a >= 40)
			System.out.print("무료 암검진 대상입니다.");
		else
			System.out.print("무료 암검진 대상이 아닙니다.");
	}
}
