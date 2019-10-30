import java.util.Scanner;
class Myinfo2
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);

		String name;
		int age;
		System.out.println("이름을 입력하세요.");
		name = sc.next();

		System.out.println("나이를 입력하세요.");
		age = sc.nextInt();

		System.out.println("당신의 이름은"+" "+name+"이고 나이는"+" "+age+"살입니다.");
	}
}