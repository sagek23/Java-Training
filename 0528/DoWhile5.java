//줄 수대로 별찍기
import java.util.*;
class  DoWhile5
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n을 입력하시오==> ");
		int n = sc.nextInt();
		int row = 1;
		do
		{	int col=1;
			do
			{
				System.out.print("*");
				col++;
			}
			while (col<=row);
			System.out.println();
			row++;
		}
		while (row<=n);
		
	}
}
