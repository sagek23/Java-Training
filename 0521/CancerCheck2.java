/*���ο����� ���� �ϰ����� �ǽ��Ϸ��� �Ѵ�. 
	����ڴ�  40�� �̻��� ����� �߿� 
	���ذ� Ȧ������ �̸� Ȧ���⵵ �¾�� 
	���� ���ذ� ¦�������̸� ¦���⵵ �¾ ����̴�.
        ȯ���� �̸��� ����⵵�� �Է¹޾� 
        ����ϰ��� ����� ���� �Ǻ��Ͽ� ����ϴ� ���α׷� �ۼ�.*/

import java.util.*;
class  CancerCheck2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Date today = new Date();
		int tyear = today.getYear()+1900;
		System.out.println("**������ ������ �Է��� �ּ���**");
		System.out.print("�̸��� �Է����ּ���==>");
		String name = sc.next();
		System.out.print("����⵵�� �Է����ּ���==>");
		int byear = sc.nextInt();
		
		if (tyear%2==0 && tyear-byear>=40 && byear%2==0)
			System.out.println("���� �ϰ��� ������Դϴ�");
		else if (tyear%2!=0 && tyear-byear>=40 && byear%2!=0)
			System.out.println("���� �ϰ��� ������Դϴ�");
		else
			System.out.println("���� �ϰ��� ����ڰ� �ƴմϴ�");
	}
}