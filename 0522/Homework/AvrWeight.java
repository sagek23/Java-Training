/*����ڷκ��� Ű�� �Է¹޾� ǥ�������� ����� �� ������� ü�߰� ���Ͽ�
��ü������, ǥ������, ��ü�������� �Ǵ��ϴ� ���α׷��� �ۼ�, ǥ��ü�� ������ 
������ ���. 
ǥ��ü�� = (Ű-100)*0.9 */
import java.util.*;
class  AvrWeight
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Ű�� �Է��ϼ���==>");
		double height = sc.nextDouble();
		double avr;
		avr = (height - 100)*0.9;
		System.out.print("ü���� �Է��ϼ���==>");
		double weight = sc.nextDouble();
		
		if (weight>avr)
			System.out.println("��ü���Դϴ�");
		else if (weight<avr)
			System.out.println("��ü���Դϴ�");
		else
			System.out.println("ǥ���Դϴ�");

		
	}
}
