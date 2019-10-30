/*0~9사이의 정수를 입력받아 한글표기식 출력하는 프로그램을 작성(switch case문 이용)*/
import java.util.*;
class DigitCount2 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("0에서 9사이의 수==> ");
		int n = sc.nextInt();

		switch(n)
		{
			case 0: 
				System.out.println("영");
				break;
			case 1: 
				System.out.println("일");
				break;

			case 2: 
				System.out.println("이");
				break;

			case 3: 
				System.out.println("삼");
				break;

			case 4: 
				System.out.println("사");
				break;

			case 5: 
				System.out.println("오");
				break;

			case 6: 
				System.out.println("육");
				break;
			case 7: 
				System.out.println("칠");
				break;

			case 8: 
				System.out.println("팔");
				break;

			case 9: 
				System.out.println("구");
				break;
		}

		System.out.println("작업종료");
	}
}
