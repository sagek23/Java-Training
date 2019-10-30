import java.util.*;
class HW1 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		double [] debt = new double[12];
		System.out.println("카드 사용금액을 입력하세요");
		for (int i=0;i<debt.length ;i++ )
		{
			System.out.print(i+1+"월: ");
			while (true)
			{
				debt[i] = sc.nextDouble();
				if (debt[i]<0)
				{
					System.out.println("잘못입력하셨습니다");
					System.out.print("다시 입력하세요==> ");
				}
				else
				{	
					sum+=debt[i];
					break;
				}	
			}
		}
		double max = debt[0];
		double min = debt[0];
		for (int i=0;i<debt.length ;i++ )
		{
			if (max<debt[i])
				max = debt[i];
			if (min>debt[i])
				min = debt[i];
		}

		System.out.println("전체사용금액: "+sum);
		System.out.println("평균사용금액: "+sum/debt.length);
		System.out.println("최고지출금액: "+max);
		System.out.println("최저지출금액: "+min);
		
		
	}
}
