import java.util.Scanner;
class fourarithmetical
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		int a,b;
		
		System.out.print("ù��° ���� �Է��ϼ���==> ");
		a = sc.nextInt();
		System.out.print("�ι�° ���� �Է��ϼ���==> ");
		b = sc.nextInt();
		int c = a + b;
		System.out.println("a + b = "+c);
		int d = a - b;
		System.out.println("a - b = "+d);
		int e = a * b;
		System.out.println("a * b = "+e);
		int f = a / b;
		System.out.println("a / b = "+f);
	}
}