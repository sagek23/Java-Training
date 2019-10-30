/*
5명 학생의 이름, 국어점수를 입력받아 성적이 높은 순으로 정렬하고 출력
*/
import java.util.*;
class  SortStudentScore
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int []score = new int[5];
		String []name = new String[5]; 
		
		for (int i=0;i<name.length ;i++ )
		{	
			System.out.print("이름을 입력하세요==> ");
			name[i] = sc.next();
			System.out.print("성적을 입력하세요==> ");
			score[i] = sc.nextInt();
			System.out.println();

		}

		for (int i=0;i<score.length ;i++ )
		{
			for (int j=i+1;j<score.length ;j++ )
			{
				if (score[i]<score[j])
				{
					int temp = score[i];
					score[i] = score[j]; //i번째와 j번째의 순서 바꾸기
					score[j] = temp;
					
					String temp2 = name[i];
					name[i] = name[j];
					name[j] = temp2;
				}
			}
		}                                                                                                                                   
		for (int i=0;i<score.length ;i++ )
		{
			System.out.println(name[i]+":"+score[i]);
		}
			
		
	}
}
