import java.util.*;
class HW4 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		double []dept ={1,2,3,4,5};
		double []sales = new double[4];
		double sum=0;
		System.out.println("����� �Է�");
		for (int i=0;i<dept.length ;i++ )
		{	
			System.out.println(i+1+"�μ�");
			for (int j=0;j<1 ;j++ )
			{
				System.out.print(j+1+"�б�: ");
				while (true)
				{
					sales[j] = sc.nextDouble();
					if (sales[j]<0)
						System.out.println("�߸��Է��ϼ̽��ϴ�");
					else
						sum+=sales[j];
						break;
				}
			}
			System.out.println("�б⺰ ��ü�����: "+sum);
		}
		

	}
}