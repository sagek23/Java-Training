/*
0000����ڿ��� ���� �Է¹޾� �������� ����ϴ� ���α׷� �ۼ�.
��, ����ڰ� �߸��� ���� �Է��ϸ� ����� �� ���� �Է��� ������ 
�ݺ�����
<���� ��>
���� �Է��ϼ���==>15
���� �Է��ϼ���==>14
���� �Է��ϼ���==>4
4���� ���Դϴ�. 
�� �Ͻðھ��?(y/n) =>k
�� �Ͻðھ��?(y/n) =>k
*/
import java.util.*;
class  HW0
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String season = "";
		int a;
		String b;
		while(true)
		{
			System.out.print("���� �Է��ϼ���==>");
			a = sc.nextInt();
			if(a<=12 && a>=1)
				break;
		
		}
			switch(a)
			{
				case 12:
				case 1:
				case 2: 
					season = "�ܿ�";
				break;

				case 3:
				case 4:
				case 5: 
					season = "��";
				break;

				case 6:
				case 7:
				case 8: 
					season = "����";
				break;

				case 9:
				case 10:
				case 11: 
					season = "����";
				break;
			}
			System.out.println(season);	
				while(true)
				{
					System.out.print("�ٽ� �Ͻðڽ��ϱ�?(y/n) ");
					b = sc.next();
					if(b.equals("y"))
						//while(true)
						//{
						//	System.out.print("���� �Է��ϼ���==>");
						//	a = sc.nextInt();
						//	if(a<=12 && a>=1)
						break;
						//}

					else if (b.equals("n"))
					{
						System.out.println("�����մϴ�");
						break;	
					}
				}

	}

}
