/*
�̸��̷κ��� ���̵� �߶�ͼ� ���
*/
import java.util.*;
class	IdFromEmail2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸����� �Է��Ͻÿ�");
		String email = sc.next();
		int n = email.indexOf("@");
		String id = email.substring(0, n);
		System.out.println("����� id�� "+id+"�Դϴ�");
	}
}
