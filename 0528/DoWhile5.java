//�� ����� �����
import java.util.*;
class  DoWhile5
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n�� �Է��Ͻÿ�==> ");
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