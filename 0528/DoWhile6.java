//�� ����� ����� (����)
import java.util.*;
class  DoWhile6
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n�� �Է��Ͻÿ�==> ");
		int n = sc.nextInt();
		int row = 1;
		do
		{	int col=n;
			do
			{
				System.out.print("*");
				col--;
			}
			while (col>=row);
			System.out.println();
			row++;
		}
		while (row<=n);
		
	}
}
