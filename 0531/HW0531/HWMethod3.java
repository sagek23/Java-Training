/*
������ ������ ���� ������ ä���ϴ� Ŭ���� Exam�� �ۼ��Ͽ�����. Exam����
10���� ������ ������ ���� ����Ǿ� �ִ�. ���� ��� ������ ����.
-----------------------------------------------------------
1) ����: "ĳ������ ������?"
   (a)������ (b)����� (c)��Ÿ�� (d)�罺��


   ��: (c)��Ÿ��
-----------------------------------------------------------

�л����� ������ ����ϱ� ���Ͽ� 7���� �̻��� ���߾�� �Ѵ�. ExamŬ����
�ȿ� �迭�� �����ϰ� ������ ���� ������ �Ŀ� �л��鿡�� ������ �����ϰ�
�л����� �䵵 ���� �迭�� �����Ѵ�. (�亯�� a,b,c,d�� �Է°����ϰ� �� ��)
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
		System.out.println("���� ����: "+ca);
	}

		public static void incorrectAnswers(int ia)
	{	
		System.out.println("���� ����: "+ia);
	}



	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String [] q = {"ĳ������ ������?","������ ������?","1+1?","50/10?","5*10?","90+10?","11*11?","48/3?","60-30?","15+35?"};
		String [] e = {"(a)������ (b)����� (c)��Ÿ�� (d)�罺��", "(a)���� (b)���� (c)���� (d)��õ","(a)3 (b)4 (c)2 (d)5",
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
					System.out.println("a, b, c, d �� �ϳ��� �Է��ϼ���");
				}
			}
			

			System.out.println("��:"+a[i]);
			for (int j=0;j<a.length ;j++ )
			{
				if (answer.equals(a[i]))
				{	
					System.out.println("����");
					System.out.println();
					score+=10;
					ca++;

					break;
				}
				else
					System.out.println("����");
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