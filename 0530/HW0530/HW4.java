import java.util.*;
class HW4 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		double []dept ={1,2,3,4,5};
		double []sales = new double[4];
		double sum=0;
		System.out.println("매출액 입력");
		for (int i=0;i<dept.length ;i++ )
		{	
			System.out.println(i+1+"부서");
			for (int j=0;j<1 ;j++ )
			{
				System.out.print(j+1+"분기: ");
				while (true)
				{
					sales[j] = sc.nextDouble();
					if (sales[j]<0)
						System.out.println("잘못입력하셨습니다");
					else
						sum+=sales[j];
						break;
				}
			}
			System.out.println("분기별 전체매출액: "+sum);
		}
		

	}
}
