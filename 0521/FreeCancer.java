import java.util.Scanner;
class  FreeCancer
{
	public static void main(String[] args) 
	{ 
		Scanner sc = new Scanner(System.in);
		int a; 
		System.out.println("����⵵�� �Է����ּ���.");
		a = sc.nextInt();
		if (a < 1981)
			System.out.print("���� �ϰ��� ����Դϴ�.");
		else
			System.out.print("���� �ϰ��� ����� �ƴմϴ�.");
	}
}