import java.util.*;
class HW1 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		double [] debt = new double[12];
		System.out.println("ī�� ���ݾ��� �Է��ϼ���");
		for (int i=0;i<debt.length ;i++ )
		{
			System.out.print(i+1+"��: ");
			while (true)
			{
				debt[i] = sc.nextDouble();
				if (debt[i]<0)
				{
					System.out.println("�߸��Է��ϼ̽��ϴ�");
					System.out.print("�ٽ� �Է��ϼ���==> ");
				}
				else
				{	
					sum+=debt[i];
					break;
				}	
			}
		}
		double max = debt[0];
		double min = debt[0];
		for (int i=0;i<debt.length ;i++ )
		{
			if (max<debt[i])
				max = debt[i];
			if (min>debt[i])
				min = debt[i];
		}

		System.out.println("��ü���ݾ�: "+sum);
		System.out.println("��ջ��ݾ�: "+sum/debt.length);
		System.out.println("�ְ�����ݾ�: "+max);
		System.out.println("��������ݾ�: "+min);
		
		
	}
}
