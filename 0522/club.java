/* 
����) ����� ������ ������ ����ƮŬ���Դϴ�. 
�������� ���Ͽ� ���̿� Ű�� �߷¹޾� ����������
�Ϸ��� �մϴ�. ���̰� 35�������̰� Ű�� 140�̻��̸� 
"���尡��"�� ����ϰ� �׷��������� "����Ұ���"��
����ϵ��� �մϴ�
*/

import java.util.*;
class  club
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("���̸� �Է��Ͽ� �ֽʽÿ� ==> ");
		int age = sc.nextInt();
		System.out.print("Ű�� �Է��Ͽ� �ֽʽÿ� ==> ");
		int height = sc.nextInt();
		
		if (age<=35 & height>=140)
		
			System.out.print("���尡��");
		else
			System.out.print("���� �Ұ���");

	}
}
