import java.util.*;
class HW2 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		double [][] sales = new double [5][4];
		double sum=0;
		System.out.println("분기별 부서의 매출액을 입력하세요");
		for (int i=0;i<5 ;i++ )
		{
			System.out.print(i+1+"부서: ");
			for (int j=0;j<4 ;j++ )
			{
				System.out.print(j+1+"분기: ");
					while (true)
				{
					sales[i][j] = sc.nextDouble();
					if (sales[i][j]<0)
					{
						System.out.println("잘못입력하셨습니다");
						System.out.print("다시 입력하세요==> ");
					}
					else
					{	
						sum+=sales[i][j];
						break;
				
					}
				}	
			}
		}
		System.out.println("분기별 부서별 매출액");
		for (int i=0;i<sales.length;i++ )
		{
			System.out.println(i+1+"부서");
			for (int j=0;i<sales.length ;i++ )
			{
				System.out.print(j+1+"분기: ");
				System.out.print(sales[i][j]+"\t");
			System.out.println();
			}
		}
		double max = sales[0][0];
		for (int i=0;i<sales.length;i++ )
		{
			for (int j=0;i<sales.length ;i++ )
			{
				if (max<sales[i][j])
					max = sales[i][j];
			}
		
		}

		System.out.println("전체사용금액: "+sum);
		System.out.println("평균사용금액: "+sum/sales.length);
		System.out.println("최고매출부서: "+max);
		
		
	}
}
