/*
����ڿ��� 10���� ������ �Է¹޾� ��� ����ϰ�
������ ���, �ְ�����,��������, 
�ְ������� ���������� ���̸� ���϶�.
*/
import java.util.*;
class  ScoreArray
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int score [] = new int[10];
		System.out.println("������ �Է��ϼ���");
		int sum = 0;
		for (int i=0;i<score.length ;i++ )
		{	
			System.out.print(i+1+"��: ");
			while (true)
			{
				score[i] = sc.nextInt();
				if (score[i]>101)
					System.out.println("�ٽ��Է� ��");
				else
					break;
			}
		}
		for (int i=0;i<score.length; i++) //for-each���� "(i+1)�� ����"�� ���Ұ�
		{	System.out.println(i+1+"�� ����: "+score[i]);
					sum+=score[i];
		}

		int max = score[0];//�Է¹ް� �� �Ŀ� ����
		int min = score[0];
		for (int i =1 ;i<score.length ;i++ )
		{
			if (max<score[i])
				max = score[i];
			if (min>score[i])
				min = score[i];
		}
		System.out.println();
		System.out.println("�ְ���: "+max);
		System.out.println("������: "+min);
		System.out.println("�ְ���-������: "+(max-min));

		System.out.println("����: "+sum);
		System.out.println("���: "+(double)sum/(score.length));


	}
}
