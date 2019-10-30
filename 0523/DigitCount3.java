/*0~9사이의 정수를 입력받아 한글표기식 출력하는 프로그램을 작성(switch case문 이용)*/
import java.util.*;
class DigitCount3 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("0에서 9사이의 수==> ");
		int n = sc.nextInt();

		switch(n)
		{
			case 0: 
				
			case 1: 
				
			case 2: 

			case 3: 
				
			case 4: 
			
			case 5: 

			case 6: 
				
			case 7: 

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
