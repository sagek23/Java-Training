/*
������ ���α׷��� �����ϵ��� �޼ҵ带 ������.
*/
class  HWMethod
{
public static void gugudan(int n)
{	//for (int i=1;i<=n ; i++)
	for (int i=1;i<=9;i++ )
	{	int g = n*i;
			System.out.println("n * "+i+" = "+g);
	}
}

public static void sum(int n) 
{
		int sum = 0;
		for (int i=1;i<=n ; i++)
		{		sum+=i;
		}
		System.out.println("����: "+sum);
}

public static int getMax(int n, int x) 
{
		int max=0;
		if (n>x)
		{
			max = n;
			
		}
		else if (n<x)
		{
			max = x;
			
		}
		return max;
}

public static int getMaxArray(int a[]) 
{
		int max = a[0];
		for (int i=1;i<a.length ; i++)
		{
			if (a[i] > max)
				max = a[i];
		}
	
		return max;
}


	public static void main(String[] args) 
	{
		gugudan(7);
		/*
		������ �߿� ����� ���� �Ű������� ���޹޾� 
		�ش� �������� ����ϴ� �޼ҵ带 ����
		*/
		sum(5);
		/*
		������ �� n�� �Ű������� ���޹޾� 1~n������ ���� 
		�����Ͽ� ����ϴ� �޼ҵ带 ����
		*/
		int max = getMax(2,3);
		/*
		�ΰ��� ������ �Ű������� ���޹޾� ���߿� ū���� ã�� ��ȯ�ϴ� �޼ҵ带 ����
		*/
		System.out.println("ū��: "+max);

		int [] a = {27,35,44,60,7};
		max = getMaxArray(a);
		// �迭�� �Ű������� ���޹޾� ���߿� ū���� 
		// ã�� ��ȯ�ϴ� �޼ҵ带 ����

		System.out.println("�迭���� ū��:" + max);
	}
}
