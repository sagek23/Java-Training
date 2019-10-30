class Util //속성없이 기능만으로 구성된 클래스. 속성이 없으므로 굳이 객체를 생성할 필요가 없다.
{
	public static double getMax(double arr2[]) //속성이 없으므로 static을 붙히면 객체없이 기능 사용가능
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
	public static int getMax(int a, int b) //기능만으로 구성.
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
		int max;			//오버로딩을 할 때 자료형과 개수가 같으면 안된다
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
