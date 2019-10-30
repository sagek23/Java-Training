/*
어떤 클래스는 속성만으로 구성될 수도 있고 
기능만으로 구성될 수도 있다.

두개의 정수를 매개변수로 전달받아 그중에 큰수를 찾아
반환하는 메소드를 갖는 클래스
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
	public int getMax(int a, int b) //기능만으로 구성.
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
class  UtilTest2
{
	public static void main(String[] args) 
	{
		Util u = new Util(); //객체생성 시 매개변수를 주려면 생성자가 있어야함
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
