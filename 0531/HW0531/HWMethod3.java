/*
객관식 문제의 시험 점수를 채점하는 클래스 Exam을 작성하여보자. Exam에는
10개의 객관식 문제와 답이 저장되어 있다. 예를 들면 다음과 같다.
-----------------------------------------------------------
1) 문제: "캐나다의 수도는?"
   (a)밴쿠버 (b)토론토 (c)오타와 (d)재스퍼


   답: (c)오타와
-----------------------------------------------------------

학생들은 시험을 통과하기 위하여 7문제 이상을 맞추어야 한다. Exam클래스
안에 배열을 선언하고 문제와 답을 저장한 후에 학생들에게 문제를 제시하고
학생들의 답도 역시 배열에 저장한다. (답변은 a,b,c,d만 입력가능하게 할 것)
*/
import java.util.*;
class  HWMethod3
{
	public static void isPassed(int score)
	{	
		if (score>=70)
			System.out.println(true);
		else if (score<=69)
			System.out.println(false);
	}

	public static void correctAnswers(int ca)
	{	
		System.out.println("정답 개수: "+ca);
	}

		public static void incorrectAnswers(int ia)
	{	
		System.out.println("오답 개수: "+ia);
	}



	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String [] q = {"캐나다의 수도는?","서울의 수도는?","1+1?","50/10?","5*10?","90+10?","11*11?","48/3?","60-30?","15+35?"};
		String [] e = {"(a)밴쿠버 (b)토론토 (c)오타와 (d)재스퍼", "(a)서울 (b)대전 (c)광주 (d)인천","(a)3 (b)4 (c)2 (d)5",
		"(a)4 (b)5 (c)10 (d)500","(a)50 (b)500 (c)100 (d)1000","(a)100 (b)190 (c)200 (d)110","(a)110 (b)121 (c)1111 (d)131",
		"(a)10 (b)16 (c)15 (d)10","(a)30 (b)20 (c)90 (d)50","(a)40 (b)50 (c)60 (d)45"}; 
		String [] a = {"c","a","c","b","a","a","b","b","a","b"};
		int score = 0;
		int ca = 0;
		int ia = 0;
		String answer ="";
		for (int i=0;i<q.length ;i++ )
		{
			System.out.println(q[i]);
			System.out.println(e[i]);
			
			while(true)
			{
				answer = sc.next();
				answer = answer.toLowerCase();

				if ((answer.equals("a"))||(answer.equals("b"))||(answer.equals("c"))||(answer.equals("d")))
					break;
				else
				{
					System.out.println("a, b, c, d 중 하나를 입력하세요");
				}
			}
			

			System.out.println("답:"+a[i]);
			for (int j=0;j<a.length ;j++ )
			{
				if (answer.equals(a[i]))
				{	
					System.out.println("정답");
					System.out.println();
					score+=10;
					ca++;

					break;
				}
				else
					System.out.println("오답");
					System.out.println();
					ia++;
					break;
					
			}
		
		}
		
		correctAnswers(ca);
		incorrectAnswers(ia);
		isPassed(score);
		
	}
}
