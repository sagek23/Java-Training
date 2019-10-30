import java.util.Scanner;
class test1
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		int a,b;
		
		System.out.print("첫번째 수를 입력하세요==> ");
		a = sc.nextInt();
		System.out.print("두번째 수를 입력하세요==> ");
		b = sc.nextInt();
		
		System.out.println(a + " + " + b + " = " + (a+b));
		System.out.println(a + " - " + b + " = " + (a-b));
		System.out.println(a + " * " + b + " = " + (a*b));
		System.out.println(a + " / " + b + " = " + (a/(double)b));
	}
}