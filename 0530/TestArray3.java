import java.util.*;
class TestArray3 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int []a = new int[10];
		
		//����ڷκ��� ������ �޾Ƽ� �迭�� �����ϴ� �ݺ�����
		for (int i=0;i<a.length;i++ )
		{	
			System.out.print((i+1)+"��° �����Է�==>");
			a[i] = sc.nextInt();
		}
		//�迭�� ����� ������ ����ϴ� �ݺ�����
		//for-each �ݺ����� ���� �Ұ�.
		for (int i=a.length-1;i>=0;i-- )
		{
			System.out.println(a[i]+"");
		}

		
		
	}
}
