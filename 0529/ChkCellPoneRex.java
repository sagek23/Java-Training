import java.util.*;
class ChkCellPoneRex
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("폰 번호 입력==> ");
		String phone = sc.next();
		if (phone.matches("\\d{3}-\\d{4}-\\d{4}")) // \d는 숫자인지 아닌지 판단. {}안에 있는 수는 숫자의 개수 판단.
			System.out.println("올바른 핸드폰 번호입니다");
		else
			System.out.println("올바른 핸드폰 번호가 아닙니다");
	}
}
