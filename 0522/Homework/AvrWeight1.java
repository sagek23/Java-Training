/*����ڷκ��� Ű�� �Է¹޾� ǥ�������� ����� �� ������� ü�߰� ���Ͽ�
��ü������, ǥ������, ��ü�������� �Ǵ��ϴ� ���α׷��� �ۼ�, ǥ��ü�� ������ 
������ ���. 
ǥ��ü�� = (Ű-100)*0.9, ǥ��ü���� ������ -1, +1�� ���� */

import java.util.*;
class  AvrWeight1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Ű�� �Է��ϼ���==>");
		double height = sc.nextDouble();
		double avr;
		avr =  (height - 100)*0.9;
		avr = Math.floor(avr); //�Ҽ��� ���� ������
		String standard;
		System.out.print("ü���� �Է��ϼ���==>");
		double weight = sc.nextDouble();	
		
		if(weight>avr+1)
			standard = "��ü��";
		else if (weight<avr-1)
			standard = "��ü��";
		else
			standard = "ǥ��";

		System.out.println(standard);
	}
}
