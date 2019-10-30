/*
연습) 사용자한테 0~9사이의 정수를 입력받아
한글표기식 출력하는 프로그램을 작성
<실행 예>
0~9사이의 수를 입력 =>8
팔
*/
import java.util.*;
class  ElseIfTest
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("0~9사이의 숫자를 입력하세요==> ");
		int a = sc.nextInt();

		if (a==1)
			System.out.print("일");
		else if (a==2)
			System.out.print("이");
		else if (a==3)
			System.out.print("삼");
		else if (a==4)
			System.out.print("사");
		else if (a==5)
			System.out.print("오");
		else if (a==6)
			System.out.print("육");
		else if (a==7)
			System.out.print("칠");
		else if (a==8)
			System.out.print("팔");
		else
			System.out.print("구");
	}
}
