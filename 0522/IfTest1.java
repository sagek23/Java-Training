/*
����) ����ڿ��� ������ ���� n�� �Է¹޾� n�� 0���� ũ�ų� ������
�� ���� ���ϰ� 100�� �� ����� ����ϰ� "�۾�����"�� ����Ѵ�.
�׷��������� �� ���� ������ ����ϰ� "�۾�����"�� ����Ѵ�
*/
import java.util.*;
class  IfTest1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ������ �Է��ϼ���==> ");
		int n = sc.nextInt();

		if (n>=0)
			System.out.println(n+100);
		else
			System.out.println(n*n);
		
		System.out.println("�۾�����");

	}
}