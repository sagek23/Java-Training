/*
����ڿ��� ���̵�, ��ȣ, ��ȣȮ�θ� �Է¹޾� �ùٸ�ȸ������
�Է¹޾� �Ǻ��ϴ� ���α׷�
id - "bitjava" pwd - "javabit"
*/
import java.util.*;
class Login 
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		String myId = "bitjava";
		String myPwd = "javabit";
		System.out.print("id�� �Է��ϼ���==> ");
		String id = sc.next();
		if (id.equals(myId))
			System.out.println("id�� Ȯ�εǾ����ϴ�");
		else
			System.out.println("id�� Ʋ�Ƚ��ϴ�.");
		System.out.print("��ȣ�� �Է��ϼ���==> ");
		String pwd = sc.next();
		if(pwd.equals(myPwd))
			System.out.println("��ȣ�� Ȯ�εǾ����ϴ�");
		else
			System.out.println("��ȣ�� Ʋ�Ƚ��ϴ�.");

		System.out.print("��ȣȮ���� �Է��ϼ���==> ");
		String pwdChk = sc.next();
		if(pwdChk.equals(pwd))
			System.out.println("�ùٸ� ��ȣ�Դϴ�");
		else
			System.out.println("��ȣ�� �ٸ��ϴ�");

		if (id.equals(myId)&&pwd.equals(myPwd)&&pwdChk.equals(pwd))
			System.out.println("�ùٸ� ȸ���Դϴ�");
		else
			System.out.println("�ùٸ� ȸ���� �ƴմϴ�");

		
		
	
	//	else
		//	System.out.println("�߸� �Է��ϼ̽��ϴ�.");
	}
}