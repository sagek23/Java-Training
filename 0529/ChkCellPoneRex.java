import java.util.*;
class ChkCellPoneRex
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ��ȣ �Է�==> ");
		String phone = sc.next();
		if (phone.matches("\\d{3}-\\d{4}-\\d{4}")) // \d�� �������� �ƴ��� �Ǵ�. {}�ȿ� �ִ� ���� ������ ���� �Ǵ�.
			System.out.println("�ùٸ� �ڵ��� ��ȣ�Դϴ�");
		else
			System.out.println("�ùٸ� �ڵ��� ��ȣ�� �ƴմϴ�");
	}
}