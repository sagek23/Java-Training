import java.util.*;
class TestArray 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int []a = new int[10];
		
		//사용자로부터 정수를 받아서 배열에 저장하는 반복루프
		for (int i=0;i<a.length;i++ )
		{	
			System.out.print((i+1)+"번째 정수입력==>");
			a[i] = sc.nextInt();
		}
		//배열에 저장된 정수를 출력하는 반복루프
		for (int i=0;i<a.length;i++  )
		{
			System.out.println(a[i]+"");
		}

		
		
	}
}
