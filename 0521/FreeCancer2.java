import java.util.*;

class  FreeCancer2
{
	public static void main(String[] args) 
	{ 
		Scanner sc = new Scanner(System.in);
		int a; 
		System.out.println("����⵵�� �Է����ּ���.");
		a = sc.nextInt();
		Date tyear = new Date(); //���� ������ ��¥�� �ð��� ������ ���� ��ü����
		int thisyear = tyear.getYear()+1900; 
		//tyear ��ü�� ���� ������ �⵵�� �о�� thisyear ������ ����
		
		if (thisyear - a >= 40)
			System.out.print("���� �ϰ��� ����Դϴ�.");
		else
			System.out.print("���� �ϰ��� ����� �ƴմϴ�.");
	}
}
