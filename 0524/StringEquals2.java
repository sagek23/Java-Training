/*����ڿ��� ��ȣ�� ��ȣȮ���� �Է¹޾�
���� ���� ������ �Ǻ�*/
import java.util.*;
class  StringEquals2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String password, check;
		System.out.println("��ȣ�� �Է��Ͻÿ�");
		password = sc.next();
		System.out.println("��ȣȮ���� �Է��Ͻÿ�");
		check = sc.next();

		//if(name == "tiger")
		if(password.equals(check))
			System.out.println("��ġ�մϴ�");
		else
			System.out.println("��ġ�����ʽ��ϴ�");
	}
}
