/*
5명 학생의 이름, 국어, 영어, 수학ㄱ을 입력바아 총점과 평균을 구하고 평균이 높은 순으로 정령
*/
import java.util.*;
class  ArrayAvgScore
{
	public static void main(String[] args) 
	{
		Scanner sc = new  Scanner(System.in);
		String name[] = new String[5];
		int[]kor = new int[5];
		int[]eng = new int[5];
		int[]math = new int[5];
		int[]tot = new int[5];
		int[]avg = new int[5];

		for (int i=0;i<name.length ;i++ )
		{
			System.out.print(i+1+"번째 학생의 이름==> ");
			name[i] = sc.next();
			System.out.print("국어==> ");
			kor[i] = sc.nextInt();
			System.out.print("영어==> ");
			eng[i] = sc.nextInt();
			System.out.print("수학==> ");
			math[i] = sc.nextInt();
			tot[i] = kor[i] + eng[i] + math[i];
			avg[i] = tot[i]/3;
		}
		for (int i=0;i<name.length ;i++ )
		{
			for (int j=0; j<name.length;j++ )
			{
				if(avg[j]>avg[i])
				{
					String s= name[i];
					name[i] = name[j];
					name [j] = s;

					int temp = kor[i];
					kor[i] = kor[j];
					kor[j] = temp;

					temp = eng[i];
					eng[i] = eng[j];
					eng[j] = temp;

					temp = math[i];
					kor[i] = kor[j];
					kor[j] = temp;

					temp = tot[i];
					tot[i] = tot[j];
					tot[j] = temp;

					temp = avg[i];
					avg[i] = avg[j];
					avg[j] = temp;
				}

				System.out.println("이름\t국어\t영어\t수학\t총점\t평균");

				for (i=0;i<name.length ; i++)
				{
					System.out.print(name[i]+"\t");
					System.out.print(kor[i]+"\t");
					System.out.print(eng[i]+"\t");
					System.out.print(math[i]+"\t");
					System.out.print(tot[i]+"\t");
					System.out.print(avg[i]);
				}
			}
		}
		
	}
}
