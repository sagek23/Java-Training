/*5.간단한 즉석복권 프로그램 작성. 1등부터 3등까지의 당첨번호 결정되어 있음.
사용자로부터 1~10사이의 번호를 받아서 2번이 1등, 5번이 2등, 7번이 3등이라고 가정.
당첨시 당첨 안내 메시지 출력*/
import java.util.*;
class  HW6
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("1~10사이의 번호를 입력하시오==> ");
		int n = sc.nextInt();
		if (n!=2 && n!=5 && n!=7)
			System.out.println("꽝");
			
		if (n==2)
			System.out.println("1등 당첨");
					
		if (n==5)
			System.out.println("2등 당첨");
					
		if (n==7)
			System.out.println("3등 당첨");
	}
}

/*
	
if (n>=11 || n<0)
System.out.print("1~10사이의 번호가 아닙니다. 다시입력하세요==> ");
		n = sc.nextInt();
*/