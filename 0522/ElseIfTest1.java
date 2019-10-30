/*
연습) 사용자한테 0~9사이의 정수를 입력받아
한글표기식 출력하는 프로그램을 작성
<실행 예>
0~9사이의 수를 입력 =>8
팔
*/
import java.util.*;
class  ElseIfTest1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("0~9사이의 숫자를 입력하세요==> ");
		int a = sc.nextInt();

		String r=""; //끝 문장이 else가 아닌경우 오류가 난다. 값이 정해지지않은 상태에서 출력될 수 없으므로.
		
		if (a==0)
			r = "영";
		else if (a==1)
			r = "일";
		else if (a==2)
			r = "이";
		else if (a==3)
			r = "삼";
		else if (a==4)
			r = "사";
		else if (a==5)
			r = "오";
		else if (a==6)
			r = "육";
		else if (a==7)
			r = "칠";
		else if (a==8)
			r = "팔";
		else if (a==9)
			r = "구";
		else 
			r = "범위를 초과하였습니다";

		System.out.println(r);
	}
}
