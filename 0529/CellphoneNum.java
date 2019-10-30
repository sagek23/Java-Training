/*
사용자에게 핸드폰 번호를 입력받아 올바른 핸드폰 번호인지 판단
xxx-xxxx-xxxx
*/
import java.util.*;
class  CellphoneNum
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("핸드폰 번호를 입력하세요==> ");
		String pNum = sc.next();

		String []phone = pNum.split("-");
		
		String a = phone[0];
		String b = phone[1];
		String c = phone[2];

		if (a.length()==3 && b.length()==4 && c.length()==4)
			System.out.println("올바른 번호입니다");
		else
			System.out.println("잘못된 번호입니다");
	
	}
}
