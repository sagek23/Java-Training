/*
다음의 프로그램이 동작하도록 메소드를 만들어라.
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
		System.out.println("총합: "+sum);
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
		구구단 중에 출력할 단을 매개변수로 전달받아 
		해당 구구단을 출력하는 메소드를 정의
		*/
		sum(5);
		/*
		임의의 수 n을 매개변수로 전달받아 1~n까지의 합을 
		누적하여 출력하는 메소드를 정의
		*/
		int max = getMax(2,3);
		/*
		두개의 정수를 매개변수로 전달받아 그중에 큰수를 찾아 반환하는 메소드를 정의
		*/
		System.out.println("큰값: "+max);

		int [] a = {27,35,44,60,7};
		max = getMaxArray(a);
		// 배열을 매개변수로 전달받아 그중에 큰수를 
		// 찾아 반환하는 메소드를 정의

		System.out.println("배열중의 큰값:" + max);
	}
}
