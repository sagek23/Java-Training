/* ����) ���ο����� ���̰� 40�� �̻��̰� Ȧ���⵵�� �¾ ����鿡�� 
����ϰ����� �ǽ��Ϸ��� �Ѵ�. ȯ���� �̸��� ����⵵�� �Է¹޾� ����
�ϰ��� ��������� �Ǻ��Ͽ� ����ϴ� ���α׷��� �ۼ��϶�*/
import java.util.*;
class  CancerCheck
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Date today = new Date();
		String name;
		int byear;
		int tyear;
		tyear = today.getYear()+1900;
		System.out.println("**������ �Է�**");
		System.out.print("�̸��� �Է��ϼ��� ==> ");
		name = sc.next();
		System.out.print("����⵵�� �Է��ϼ��� ==> ");
		byear = sc.nextInt();

		if (byear%2!=0 && tyear - byear >= 40)
			System.out.println("���� �ϰ��� ����Դϴ�");
		else
			System.out.println("���� �ϰ��� ����� �ƴմϴ�");
	}
}
