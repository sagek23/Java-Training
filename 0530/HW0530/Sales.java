/* < 프로그래밍 4번 >
	어떤 회사의 분기별 매출액을 저장하는 클래스 Sales 를 작성하자.
	회사에는 5개의 부서가 있고, 각 부서의 매출액이 이차원 배열에 저장된다. 
	매출액은 사용자가 입력하도록 하고 이때 음수가 입력되면 안된다.
	다음과 같은 메소드를 제공하도록 하자.
	1). 분기별 부서별 매출액 출력
	2). 분기별 회사 전체의 매출액 출력
	3). 분기별 회사 전체의 평균 매출액 출력
	4). 특정 분기에 최고의 매출을 올린 부서 출력
*/

import java.util.Scanner;
class Sales
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		// 4분기 각 5개 부서별 매출액
		int[][] sal = new int[4][5];
		int sum=0;

		for(int i=0; i<4; i++) // i는 분기
		{
			System.out.println("\n** "+(i+1)+" 분기 부서별 매출액 **\n");
			for(int j=0; j<5; j++) // j는 부서
			{
				System.out.print((j+1)+"부서 : ");
				sal[i][j] = sc.nextInt();

				if( sal[i][j] < 0 ) // 음수인지 확인
				{
					System.out.println("금액을 잘못 입력하였습니다. 확인 후 다시 작성해주세요.");
					return;
				}				
			}
		}
		for(int i=0; i<4; i++)
		{
			System.out.println("\n< "+(i+1)+" 분기 >\n");
			for(int j=0; j<5; j++)
				System.out.print("▶ "+(j+1)+"부서 : "+sal[i][j]+"\t");
			System.out.println();
		}

		for(int i=0; i<4; i++)
		{
			sum=0;
			for(int j=0; j<5; j++)
				sum += sal[i][j];
			System.out.println((1+i)+"분기 전체 매출액 : "+sum);
			System.out.println((1+i)+"분기 전체 평균 매출액 : "+sum/5);
		}
		// 특정 분기에 최고의 매출을 올린 부서 출력
		int max = sal[0][0];
		for (int i=0; i<4; i++ )
		{
			for (int j=0; j<5; j++ )
				if( max < sal[i][j] )
					max = sal[i][j];
//			System.out.println("최고의 매출을 올린 부서는 "+(1+i)+"분기의 "+(1+j)+"부서 입니다!");
		}
		for (int i=0; i<4; i++ )
			for (int j=0; j<5; j++ )
				if( sal[i][j] == max )
					System.out.println("최고의 매출을 올린 부서는 "+(1+i)+"분기의 "+(1+j)+"부서 입니다!");
	}
}
