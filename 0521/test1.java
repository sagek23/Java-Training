import java.util.Scanner;
class test1
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		int a,b;
		
		System.out.print("ù��° ���� �Է��ϼ���==> ");
		a = sc.nextInt();
		System.out.print("�ι�° ���� �Է��ϼ���==> ");
		b = sc.nextInt();
		
		System.out.println(a + " + " + b + " = " + (a+b));
		System.out.println(a + " - " + b + " = " + (a-b));
		System.out.println(a + " * " + b + " = " + (a*b));
		System.out.println(a + " / " + b + " = " + (a/(double)b));
	}
}