/*
����) ����ڿ��� ���� �Է¹޾� �� ���� ���ϱ��� �ִ��� �Ǻ��Ͽ� ����ϵ��� �Ѵ�.
*/
import java.util.*;
class  Month
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int lastday;
		System.out.print("���� �Է����ּ���==>");
		int month = sc.nextInt();
		
		
		if (month<1 || month>12)
		{
			System.out.println("1~12������ ���ڸ� �Է��ϼ���");
			return;
		}
		
		if (month==4 || month==6 || month==9 || month==11)
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
		 	System.out.println(month+"����"+lastday+"���� �־��");
	}
}


/*
31�� - 1, 3, 5,7,8, 10, 12
30�� - 4, 6, 9, 11
28�� - 2
*/