/*���ο����� ���� �ϰ����� �ǽ��Ϸ��� �Ѵ�. 
	����ڴ�  40�� �̻��� ����� �߿� 
	���ذ� Ȧ������ �̸� Ȧ���⵵ �¾�� 
	���� ���ذ� ¦�������̸� ¦���⵵ �¾ ����̴�.
        ȯ���� �̸��� ����⵵�� �Է¹޾� 
        ����ϰ��� ����� ���� �Ǻ��Ͽ� ����ϴ� ���α׷� �ۼ�.*/

import java.util.*;
class  CancerCheck3
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
		int age = tyear-byear;
		if (tyear%2==byear%2 && age>=40)
			System.out.println("���� �ϰ��� ������Դϴ�");
		else
			System.out.println("���� �ϰ��� ����ڰ� �ƴմϴ�");
	}
}