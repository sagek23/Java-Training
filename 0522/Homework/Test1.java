import java.util.Scanner;
class  Test1

{
	public static void main(String[] args) 
	{
			int score;
		Scanner input = new Scanner(System.in);
		System.out.printf("������ �Է��Ͻÿ�: ");
			score = input.nextInt();
		String str = (score>=60)?"�հ�":"���հ�";
		System.out.println(str);
	}
}
