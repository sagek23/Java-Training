/*����)
������ �̸�, �ּ�, ����, Ű, ��ȭ��ȣ�� �Է¹޾� ����ϴ�
���α׷� �ۼ�
(��, �ּҴ� ������� �Է¹޵��� �Ѵ�)*/
/*next()�� �����̳� ����Ű�� ���ؼ� �Է��� ���еȴ�.
�����̽��� ������ �Է��� ���������� ó���ȴ�. �׷���
���鹮�ڸ� �����Ͽ� �Է¹��� �� ����. ���鹮�ڱ��� �����Ͽ�
�Է��Ϸ��� nextLine()�� ����ؾ��Ѵ�.next()�� nextLine()��
���۹���� �ٸ��� ������ ȥ���ؼ� ����ϸ� �̻��ϰ� �����Ѵ�*/

import java.util.*;
class customer2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String a,b,e;
		int c;
		double d;
		
		System.out.println("�������� �̸��� �Է��Ͽ� �ֽʽÿ�");
		a = sc.next();
		
		sc.nextLine(); 

		System.out.println("�ּҸ� �Է��Ͽ� �ֽʽÿ�");
		b = sc.nextLine(); //������ �־ �ּҸ� �Է�
		System.out.println("���̸� �Է��Ͽ� �ֽʽÿ�");
		c = sc.nextInt();
		System.out.println("Ű�� �Է��Ͽ� �ֽʽÿ�");
		d = sc.nextDouble();
		System.out.println("��ȭ��ȣ�� -���� �Է��Ͽ� �ֽʽÿ�");
		e = sc.next();
		
		System.out.println("**��������**");
		System.out.println("�̸�: " + a );
		System.out.println("�ּ�: " + b );
		System.out.println("����: " + c );
		System.out.println("Ű: " + d +"cm");
		System.out.println("��ȭ��ȣ: " + e);
	}
}