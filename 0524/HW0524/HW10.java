/*11.Ư���� ������ �Է¹޾� �� ���� ���̿� �ִ� ��� 3�� ����� ����ϴ� ���α׷��� �ۼ�.
���� �Է°��� 0���� ������ ���� �޽����� ���*/
import java.util.*;
class  HW10
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���ڸ� �Է��Ͻÿ�==> ");
		int i;
		int n = sc.nextInt();
		if (n<=0)	
				while (true)
				{
					System.out.print("0���� ū ���� �Է��ϼ���==> ");
					n = sc.nextInt();
					if(n!=0)
						break;
				}
			//int n = sc.nextInt();
		for (i=1;i<=n;i++)
		{
			if(i%3==0)
				System.out.println(i);
		}
	}
		
		

}


