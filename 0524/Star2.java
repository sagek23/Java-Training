/*
������ ���� �����ϴ� ���α׷� �ۼ�
���� ���� ����ұ��? 3
���� ��ĭ ����ұ��? 4
****
****
****
*/
import java.util.*;
class  Star2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� ����ұ�?==> ");
		int a = sc.nextInt();
		System.out.print("���� ��ĭ ����ұ�?==> ");
		int b = sc.nextInt();
		
		for (int i=1;i<=a ;i++ )
		{
			for (int j=1;j<=b ;j++ )
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}
}
