/*8. ��ǻ�Ϳ� ���������� �����ϴ� ���α׷�. ��ǻ�ʹ� ����ڿ��� �˸��� �ʰ� ���������� 
�߿��� ������ �ϳ��� ����. ����ڴ� ���α׷��� �Է¾ȳ� �޽����� ���� 3�� �߿��� �ϳ���
�����ϰ� �ȴ�. ������� ������ ������ ��ǻ�ʹ� ���� ������ �����Ͽ��� ���� �̰���� ������
�˷��ش�.*/
import java.util.*;
class HW8 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		System.out.println("���������� ����. ���� �� �ϳ��� �����Ͻÿ�");
		System.out.print("1.����, 2.����, 3.��==> ");
		
		int a;
		int r;
		
		while (true)
		{
			a = sc.nextInt();
			r = ran.nextInt(3)+1;
			if (a<=3 && a>0)
				break;
			else
				System.out.print("�ٽ� �Է��ϼ���==>");
		}
		String str="";


		if (r==1)
			str = "com: ����";
		else if (r==2)
			str="com: ����";
		else if (r==3)	
			str="com: ��";

		if (a==r)
		{	System.out.println(str);
			System.out.println("�����ϴ�");
		}
		else if (a==1 && r==3)
		{
			System.out.println(str);
			System.out.println("YOU WIN");
		}
		else if (a==1 && r==2)
		{
			System.out.println(str);
			System.out.println("YOU LOSE");
		}
		else if (a==2 && r==1)
		{
			System.out.println(str);
			System.out.println("YOU WIN");
		}
		else if (a==2 && r==3)
		{
			System.out.println(str);
			System.out.println("YOU LOSE");
		}
		else if (a==3 && r==1)
		{
			System.out.println(str);
			System.out.println("YOU LOSE");
		}
		else if (a==3 && r==2)
		{
			System.out.println(str);
			System.out.println("YOU WIN");
		}
	}
}



		/*
		*/