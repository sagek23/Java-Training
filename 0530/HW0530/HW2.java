import java.util.*;
class HW2 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		double [][] sales = new double [5][4];
		double sum=0;
		System.out.println("�б⺰ �μ��� ������� �Է��ϼ���");
		for (int i=0;i<5 ;i++ )
		{
			System.out.print(i+1+"�μ�: ");
			for (int j=0;j<4 ;j++ )
			{
				System.out.print(j+1+"�б�: ");
					while (true)
				{
					sales[i][j] = sc.nextDouble();
					if (sales[i][j]<0)
					{
						System.out.println("�߸��Է��ϼ̽��ϴ�");
						System.out.print("�ٽ� �Է��ϼ���==> ");
					}
					else
					{	
						sum+=sales[i][j];
						break;
				
					}
				}	
			}
		}
		System.out.println("�б⺰ �μ��� �����");
		for (int i=0;i<sales.length;i++ )
		{
			System.out.println(i+1+"�μ�");
			for (int j=0;i<sales.length ;i++ )
			{
				System.out.print(j+1+"�б�: ");
				System.out.print(sales[i][j]+"\t");
			System.out.println();
			}
		}
		double max = sales[0][0];
		for (int i=0;i<sales.length;i++ )
		{
			for (int j=0;i<sales.length ;i++ )
			{
				if (max<sales[i][j])
					max = sales[i][j];
			}
		
		}

		System.out.println("��ü���ݾ�: "+sum);
		System.out.println("��ջ��ݾ�: "+sum/sales.length);
		System.out.println("�ְ����μ�: "+max);
		
		
	}
}
