class Util //�Ӽ����� ��ɸ����� ������ Ŭ����. �Ӽ��� �����Ƿ� ���� ��ü�� ������ �ʿ䰡 ����.
{
	public static double getMax(double arr2[]) //�Ӽ��� �����Ƿ� static�� ������ ��ü���� ��� ��밡��
	{
		double max = arr2[0];
		for (int i=1;i<arr2.length; i++)
		{
			if (max<arr2[i])
				max = arr2[i];
		}
		return max;
	}
	public static int getMax(int arr[])
	{
		int max= arr[0];
		for (int i=1;i<arr.length; i++)
		{
			if (max<arr[i])
				max = arr[i];
		}
		return max;
	}
	public static double getMax(double a, double b) 
	{
		double max;
		if (a>b)
			max = a;
		else
			max = b; 

		return max;
	}
	public static int getMax(int a, int b) //��ɸ����� ����.
	{
		int max;
		if (a>b)
			max = a;//return a;
		else
			max = b; //return b;

		return max;
	}
	public static int getMax(int a, int b, int c) 
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
class  StaticTest
{
	public static void main(String[] args) 
	{
		
		
		System.out.println(Util.getMax(10,34));
		System.out.println(Util.getMax(10,34,50));
		int arr[] = {6,9,15,26,2};
		System.out.println(Util.getMax(arr));
		double arr2[] = {26.7,27.2,15,75};
		System.out.println(Util.getMax(arr2));
		System.out.println(Util.getMax(25.5,28.4));

	}
}