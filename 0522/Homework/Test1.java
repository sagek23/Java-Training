import java.util.Scanner;
class  Test1

{
	public static void main(String[] args) 
	{
			int score;
		Scanner input = new Scanner(System.in);
		System.out.printf("성적을 입력하시오: ");
			score = input.nextInt();
		String str = (score>=60)?"합격":"불합격";
		System.out.println(str);
	}
}
