import java.util.Scanner;
class circle
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		double a;
		System.out.print("원의 반지름을 입력하세요== ");
		a = sc.nextDouble();
		double b = 2 * a * 3.14;
		System.out.println("원의 둘레는"+b);
		double c = a  * a * 3.14;
		System.out.println("원의 넓이는"+c);
	
	}
}