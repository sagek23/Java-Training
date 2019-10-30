/*
사용자에게 10명의 점수를 입력받아 모두 출력하고
총점과 평균, 최고점수,최저점수, 
최고점수와 최저점수의 차이를 구하라.
*/
import java.util.*;
class  ScoreArray
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int score [] = new int[10];
		System.out.println("점수를 입력하세요");
		int sum = 0;
		for (int i=0;i<score.length ;i++ )
		{	
			System.out.print(i+1+"번: ");
			while (true)
			{
				score[i] = sc.nextInt();
				if (score[i]>101)
					System.out.println("다시입력 ㄱ");
				else
					break;
			}
		}
		for (int i=0;i<score.length; i++) //for-each문은 "(i+1)번 점수"를 사용불가
		{	System.out.println(i+1+"번 점수: "+score[i]);
					sum+=score[i];
		}

		int max = score[0];//입력받고 난 후에 선언
		int min = score[0];
		for (int i =1 ;i<score.length ;i++ )
		{
			if (max<score[i])
				max = score[i];
			if (min>score[i])
				min = score[i];
		}
		System.out.println();
		System.out.println("최고점: "+max);
		System.out.println("최저점: "+min);
		System.out.println("최고점-최저점: "+(max-min));

		System.out.println("총점: "+sum);
		System.out.println("평균: "+(double)sum/(score.length));


	}
}
