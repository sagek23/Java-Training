import java.util.Scanner;
class Myinfo2
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);

		String name;
		int age;
		System.out.println("�̸��� �Է��ϼ���.");
		name = sc.next();

		System.out.println("���̸� �Է��ϼ���.");
		age = sc.nextInt();

		System.out.println("����� �̸���"+" "+name+"�̰� ���̴�"+" "+age+"���Դϴ�.");
	}
}