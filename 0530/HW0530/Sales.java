/* < ���α׷��� 4�� >
	� ȸ���� �б⺰ ������� �����ϴ� Ŭ���� Sales �� �ۼ�����.
	ȸ�翡�� 5���� �μ��� �ְ�, �� �μ��� ������� ������ �迭�� ����ȴ�. 
	������� ����ڰ� �Է��ϵ��� �ϰ� �̶� ������ �ԷµǸ� �ȵȴ�.
	������ ���� �޼ҵ带 �����ϵ��� ����.
	1). �б⺰ �μ��� ����� ���
	2). �б⺰ ȸ�� ��ü�� ����� ���
	3). �б⺰ ȸ�� ��ü�� ��� ����� ���
	4). Ư�� �б⿡ �ְ��� ������ �ø� �μ� ���
*/

import java.util.Scanner;
class Sales
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		// 4�б� �� 5�� �μ��� �����
		int[][] sal = new int[4][5];
		int sum=0;

		for(int i=0; i<4; i++) // i�� �б�
		{
			System.out.println("\n** "+(i+1)+" �б� �μ��� ����� **\n");
			for(int j=0; j<5; j++) // j�� �μ�
			{
				System.out.print((j+1)+"�μ� : ");
				sal[i][j] = sc.nextInt();

				if( sal[i][j] < 0 ) // �������� Ȯ��
				{
					System.out.println("�ݾ��� �߸� �Է��Ͽ����ϴ�. Ȯ�� �� �ٽ� �ۼ����ּ���.");
					return;
				}				
			}
		}
		for(int i=0; i<4; i++)
		{
			System.out.println("\n< "+(i+1)+" �б� >\n");
			for(int j=0; j<5; j++)
				System.out.print("�� "+(j+1)+"�μ� : "+sal[i][j]+"\t");
			System.out.println();
		}

		for(int i=0; i<4; i++)
		{
			sum=0;
			for(int j=0; j<5; j++)
				sum += sal[i][j];
			System.out.println((1+i)+"�б� ��ü ����� : "+sum);
			System.out.println((1+i)+"�б� ��ü ��� ����� : "+sum/5);
		}
		// Ư�� �б⿡ �ְ��� ������ �ø� �μ� ���
		int max = sal[0][0];
		for (int i=0; i<4; i++ )
		{
			for (int j=0; j<5; j++ )
				if( max < sal[i][j] )
					max = sal[i][j];
//			System.out.println("�ְ��� ������ �ø� �μ��� "+(1+i)+"�б��� "+(1+j)+"�μ� �Դϴ�!");
		}
		for (int i=0; i<4; i++ )
			for (int j=0; j<5; j++ )
				if( sal[i][j] == max )
					System.out.println("�ְ��� ������ �ø� �μ��� "+(1+i)+"�б��� "+(1+j)+"�μ� �Դϴ�!");
	}
}
