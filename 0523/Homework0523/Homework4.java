/*����4) ����ڷ� ���� ������ �� N�� �Է¹޾� 
		�� ���� �Ҽ����� �Ǻ��ϴ� ���α׷��� �ۼ��մϴ�.
       (�Ҽ��� 1�� �ڱ��ڽ����θ� ������ ���� ���� ���մϴ�.
       �� ����� ������ 2���� ���� ���մϴ�.)
*/
import java.util.*;
class  Homework4
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n�� �Է��Ͻÿ�==> ");
		int n = sc.nextInt();
		int count = 0;

		for (int i=1;i<=n ;i++ )
		{
			if (n%i==0)
			{
				count += 1;	
			}	
		}
		if(count!=2)
			System.out.println(n+"��/�� �Ҽ��� �ƴ�");
		else
			System.out.println(n+"��/�� �Ҽ�");
	}
}
