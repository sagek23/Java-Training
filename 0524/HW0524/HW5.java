
/*4.키보드에서 영문자 하나를 읽어서 모음과 자음으로 구분하는 프로그램 작성/
switch문 사용*/
import java.util.*;
class  HW5
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("알파벳을 입력하시오==> ");
		char al = sc.next().charAt(0);

		switch (al)
		{
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				System.out.println("모음");
				break;
			default:
				System.out.println("자음");
				
		}
	}
}
