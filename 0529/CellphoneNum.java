/*
����ڿ��� �ڵ��� ��ȣ�� �Է¹޾� �ùٸ� �ڵ��� ��ȣ���� �Ǵ�
xxx-xxxx-xxxx
*/
import java.util.*;
class  CellphoneNum
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�ڵ��� ��ȣ�� �Է��ϼ���==> ");
		String pNum = sc.next();

		String []phone = pNum.split("-");
		
		String a = phone[0];
		String b = phone[1];
		String c = phone[2];

		if (a.length()==3 && b.length()==4 && c.length()==4)
			System.out.println("�ùٸ� ��ȣ�Դϴ�");
		else
			System.out.println("�߸��� ��ȣ�Դϴ�");
	
	}
}
