/*
5�� �л��� �̸�, ���������� �Է¹޾� ������ ���� ������ �����ϰ� ���
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
			System.out.print("�̸��� �Է��ϼ���==> ");
			name[i] = sc.next();
			System.out.print("������ �Է��ϼ���==> ");
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
					score[i] = score[j]; //i��°�� j��°�� ���� �ٲٱ�
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
