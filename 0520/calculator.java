import java.util.Scanner;
class calculator
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		
		System.out.println("���� a�� �Է��ϼ���.");
		a = sc.nextInt();
		System.out.println("���� b�� �Է��ϼ���.");
		b = sc.nextInt();
		int c = a + b;
		System.out.println("a + b = "+c);
	}
}