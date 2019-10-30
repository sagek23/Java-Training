import java.util.Scanner;
class circle1
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		double a;
		System.out.print("원의 반지름을 입력하세요==> ");
		a = sc.nextDouble();
		System.out.println("원의 둘레는 "+ (2 * a * 3.14));
		System.out.println("원의 넓이는 "+ (a * a * 3.14));
	
	}
}