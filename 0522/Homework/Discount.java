/*�������� �ϳ��� 100���� ������ �Ǹ��ϰ� �ִٰ� ��������. ������ 10�� �̻�
�����ϴ� �����Դ� 10%�� �������شٰ� ����. ����ڰ� ������ ������ ������ 
�Է��ϸ� ��ü������ �������� ������ִ� ���α׷��� �ۼ��϶�. �� ������
������ 10�̻��̸� 10% ������ �������� ����� �Ͽ����Ѵ�. if-else���� ����϶�*/
import java.util.*;
class  Discount
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("10�� �̻��� �����Ͻø� 10% �����ص帳�ϴ�.");
		System.out.print("�����Ͻ� ������ ������ �Է����ּ���==> ");
		int purchase = sc.nextInt();
		double price;

		if (purchase>=10)
		{
			price = (purchase*100)*0.9;
			System.out.println("10% ���ι����� �� �ֽ��ϴ�");
		}
		else	
			price = purchase*100;
		
		System.out.println(price+"�� �Դϴ�");
		
	}
}
