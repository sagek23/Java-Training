/*
<�ɸ��׽�Ʈ>
���ӱ��� �Ȱ� �ִµ� ���谡 �������ִ�.
1)�ݴ´�
2)�����ʴ´�
2��
(��鼭 ������ �ٶ�°� �ٶ��� �ʴ°�)

2.���ڴ��̳� ���ִ��� ��������� ���� ���� ��Ÿ����.
���� ���̴� ��������̸� ������?
3����
(�̼����� ���� ����� ����)

3. �������� ���ٴ� ���� ����. 
ù��° �湮�� ����� �̹��� ���� �Ͼ���� ���̴�.
����, ���� �� ��� �Ͼ���� ���̴�.
�̶� � �������� �����.
�� ��������
(�¾�� �� ����)

4. �� ���� �湮�� �������� �� �濡�� â��, ħ��, 
������ �ִ�. â���� ����Ͱ� ħ�뿡 �ɾƺ��� �Ͱ�
������ �����ʹ�. �ñ��� ������� �����ض�. 
����-â��-ħ��
(����ڸ� ���� �� ���� �� ���-���-�� ��� �ڽ�)

5. â���� �������� â�� �ۿ� �������� ���δ�.
�ű⿡ ��ģ�� ������ �ϰ��ִ�.
�׶� ����� �ൿ��?
���ϳİ� �Ҹ�ģ��
(����ڰ� �ܵ��� �ൿ)

6. ������ �湮�� ����� ������ �������� ��𼱰�
Ŀ������ ����. �׶� ����� �ൿ��?
���� �ʴ´�.
(������ �޾Ƶ��̴� �µ�)
*/
import java.util.*;
class  PsyTest4
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try{
			System.out.println("1. ���ӱ��� �Ȱ� �ִµ� ���� ���谡 �������ִ�. ����� ��� �ϰڴ°�");
			System.out.print("1)�ݴ´� 2)�����ʴ´�==>" );
			int a = sc.nextInt();
			
			
				while(true)
				{	
					if(a==1 || a==2)
						break;
					else
					System.out.print("��ȣ�� �ٽ� �����ϼ���==> ");
					a = sc.nextInt(); 
				}
					if(a==1)
						System.out.println("�ݴ´ٸ� ������ ����� �λ����� ������ �ٶ�� ����Դϴ�");
					else if (a==2)
						System.out.println("�ݴ´ٸ� ������ ����� �λ����� ������ �ٶ����ʰ� �����ϰ� ��� ����Դϴ�");
						System.out.println("");	
			}catch(Exception e)
			{
				System.out.println("���ڸ� �Է��ؾ��մϴ�.");	
				sc.nextLine();
			}
			
		try{
			System.out.println("2. ���ڴ��̳� ���ִ��� ��������� ���� ���� ��Ÿ����. ���� ���̴� ��������̸� ������?");
			System.out.print("1)���� 2)1m 3)2m�̻�==> " );
			int b = sc.nextInt();
				while(true)
				{	
					if(b==1 || b==2 ||b ==3)
						break;
					else
					System.out.print("��ȣ�� �ٽ� �����ϼ���==> ");
					b = sc.nextInt(); 
				}
					System.out.println("���� ���̴� �̼����� ���� ����� ���̸� ���մϴ�");
					if (b==1)
						System.out.println("���ٸ� ������ ����� �̼��� ���� �������ʰ� �� ������ ����Դϴ�");
					else if (b==2)
						System.out.println("1m�� ������ ����� �̼����� ���� ������ ������ ������ �����Ƿ� �̼����谡 �������ʽ��ϴ�");
					else if (b==3)
						System.out.println("2m�̻� ������ ����� �̼����� ���� ���� ����� ������� �̼����迡 �������� ������ �������� �𸣰ڽ��ϴ�");
					System.out.println("");
			}catch(Exception e)
			{
				System.out.println("���ڸ� �Է��ؾ��մϴ�.");
				sc.nextLine();
			}
			
		try{
			sc.nextLine();
			System.out.println("3. �������� ���ٴ� ���� ����. ù��° �湮�� ����� �̹��� ���� �Ͼ���� ���̴�.����, ���� �� ��� �Ͼ���� ���̴�.�̶� � �������� �����.");
			String c = sc.nextLine();
			System.out.println(c+": �̰��� �ڽ��� �¾�� ���� �����Դϴ�");
			System.out.println("");

			System.out.println("4. �� ���� �湮�� �������� �� �濡�� â��, ħ��, ������ �ִ�. â���� ����Ͱ� ħ�밡 ǫ������ �ɾƺ��� �Ͱ� ���忡 ���� �ִ��� �ñ��ϴ�. ������ ���� ���� �� ������ �����.");
			String d = sc.next();
						while(true)
					{	
						if(d.equals("â��")||d.equals("����") ||d.equals("ħ��"))
							break;
						else
						System.out.print("�ٽ� �����ּ���==> ");
						d = sc.next(); 
					}
							System.out.println("�̰��� ����� ����ڸ� ������ �� ���� �߿�� �ϴ� ���Դϴ�");
						if (d.equals("â��"))
							System.out.println(d+"�� �����Ѵ���� ����ڸ� �����Ҷ� �� ����� ����� ���� �߿���մϴ�");
						else if(d.equals("����"))
							System.out.println(d+"�� ������ ����� ����ڸ� �����Ҷ� �� ����� ���� ���� ���� �߿���մϴ�");
						else if(d.equals("ħ��"))
							System.out.println(d+"�� ������ ����� ����ڸ� �����Ҷ� �� ��� ��ü�� ���� �߿���մϴ�");
						System.out.println("");
			}catch(Exception e)
			{
				System.out.println("���ڸ� �Է��ؾ��մϴ�.");
				sc.nextLine();
			}
		
		try{
			System.out.println("5. â���� �������� â�� �ۿ� �������� ���δ�.�ű⿡ ���� Ȥ�� ����ڰ� ������ �ϰ��ִ�.�׶� ����� �ൿ��?");
			System.out.print("1)�Ҹ�ģ�� 2)�Ĵٺ��� 3)���� �����Ѵ�==>" );
			int e = sc.nextInt();
					while(true)
				{	
					if(e==1 || e==2 ||e ==3)
						break;
					else
					System.out.print("��ȣ�� �ٽ� �����ϼ���==> ");
					e = sc.nextInt(); 
				}
					if (e==1)
						System.out.println("1���� ������ ����� ������� �ܵ����� ���谳���� �Ϸ��� ����Դϴ�");
					else if (e==2)
						System.out.println("2���� ������ ����� ����ڰ� �ܵ��� �ϸ� �״�� ���踦 ������ ����Դϴ�");
					else if (e==3)
						System.out.println("3���� ������ ����� ����ڰ� �ܵ��� �ϸ� ���� �ܵ��� �ϴ� ����Դϴ�");
						System.out.println("");
			}catch(Exception e)
			{
				System.out.println("���ڸ� �Է��ؾ��մϴ�.");
				sc.nextLine();
			}
			
		try {
			System.out.println("6. ������ �湮�� ����� ������ �������� ��𼱰� Ŀ������ ����. �׶� ����� �ൿ��?");
			System.out.print("1)���� �ʴ´� 2)���ʸ� �Ҵ� 3)����==>" );
			int f = sc.nextInt();
				while(true)
				{	
					if(f==1 || f==2 ||f ==3)
						break;
					else
					System.out.print("��ȣ�� �ٽ� �����ϼ���==> ");
					f = sc.nextInt(); 
				}
					if (f==1)
						System.out.println("1���� ������ ����� ������ ������ �޾Ƶ��̷� �����ʴ� ����Դϴ�");
					else if (f==2)
						System.out.println("2���� ������ ����� ������ ������ �޾Ƶ��̷� �����ʴ� ����Դϴ�");
					else if (f==3)
						System.out.println("3���� ������ ����� ������ ������ �޾Ƶ��̴� ����Դϴ�");
			}catch(Exception e)
			{
				System.out.println("���ڸ� �Է��ؾ��մϴ�.");
				sc.nextLine();
			}


	}
}