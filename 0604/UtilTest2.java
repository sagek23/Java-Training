/*
� Ŭ������ �Ӽ������� ������ ���� �ְ� 
��ɸ����� ������ ���� �ִ�.

�ΰ��� ������ �Ű������� ���޹޾� ���߿� ū���� ã��
��ȯ�ϴ� �޼ҵ带 ���� Ŭ����
*/
class Util
{
	public double getMax(double arr2[])
	{
		double max = arr2[0];
		for (int i=1;i<arr2.length; i++)
		{
			if (max<arr2[i])
				max = arr2[i];
		}
		return max;
	}
	public int getMax(int arr[])
	{
		int max= arr[0];
		for (int i=1;i<arr.length; i++)
		{
			if (max<arr[i])
				max = arr[i];
		}
		return max;
	}
	public double getMax(double a, double b) 
	{
		double max;
		if (a>b)
			max = a;
		else
			max = b; 

		return max;
	}
	public int getMax(int a, int b) //��ɸ����� ����.
	{
		int max;
		if (a>b)
			max = a;//return a;
		else
			max = b; //return b;

		return max;
	}
	public int getMax(int a, int b, int c) 
	{
		int max;			//�����ε��� �� �� �ڷ����� ������ ������ �ȵȴ�
		if (a>b)
			if (a>c)
				max = a;
			else
				max = c;
		else if(b>c)
			max = b;
			else
				max=c;

		return max;
	}
}
class  UtilTest2
{
	public static void main(String[] args) 
	{
		Util u = new Util(); //��ü���� �� �Ű������� �ַ��� �����ڰ� �־����
		//u.getMax(2,3);
		System.out.println(u.getMax(10,34));
		System.out.println(u.getMax(10,34,50));
		int arr[] = {6,9,15,26,2};
		System.out.println(u.getMax(arr));
		double arr2[] = {26.7,27.2,15,75};
		System.out.println(u.getMax(arr2));
		System.out.println(u.getMax(25.5,28.4));

	}
}
