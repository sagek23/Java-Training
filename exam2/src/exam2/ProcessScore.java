package exam2;

public class ProcessScore {
	public ProcessScore(int []arr)	throws IllegalScore
	{
		int sum = 0;
		for (int score:arr)
		{
			if (score<0)
			{
				throw new IllegalScore("������ ����� �Է����ּ���");
			}
			sum+=score;
		}
		int avg = sum/arr.length;
		System.out.println("���: "+avg);
	}
}
