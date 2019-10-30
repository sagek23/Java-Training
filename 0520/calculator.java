import java.util.Scanner;
class calculator
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		
		System.out.println("정수 a를 입력하세요.");
		a = sc.nextInt();
		System.out.println("정수 b를 입력하세요.");
		b = sc.nextInt();
		int c = a + b;
		System.out.println("a + b = "+c);
	}
}