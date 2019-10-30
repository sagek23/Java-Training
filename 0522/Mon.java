
import java.util.*;
class  Mon
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int lastday;
		System.out.print("월을 입력해주세요==>");
		int month = sc.newInt();
		
		
		if (month<1 || month>12)
		{
			System.out.println("1~12까지의 숫자만 입력하세요");
			return;
		}
		
		if (month == 4 || month == 6 || month == 9 || month == 11);
		{	
			lastday = 30;
		}
		else if (month==2)
		{	
			lastday = 28;
		}
		
		else
		{	
			lastday = 31;
		}
		 	
		System.out.println(month+"월은"+lastday+"까지 있어요");
	}
}
