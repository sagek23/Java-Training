
import java.util.Scanner;
class Homework1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		String win = "â", bad = "ħ";
		int sol=0,sol2=0;
		String sol3="",sol4="",sol5="",sol6="";
		String yn="";
		boolean b = true;
		while(b){
			System.out.println("�š�� �ɸ� �׽�Ʈ �ġ��");
			System.out.println();
		while(true)
		{
			try
			{				
					System.out.println("�ɸ��׽�Ʈ1)");
					System.out.println("�Ƹ��ٿ� ���ӱ��� �Ȱ� �־����ϴ�.");
					System.out.println("���տ� ���� ���谡 ������ �ֽ��ϴ�.");
					System.out.println("����̶�� �ݰڽ��ϱ�? �����ʰڽ��ϱ�?");
					System.out.println();
					System.out.println("1. �ݴ´�.   2.�����ʴ´�.(1,2)");
					sol = sc.nextInt(); 
					
					if(sol==1||sol==2) break;
					else System.out.println("�ٽ� �Է��Ͻʽÿ�");
					
						
			}catch (Exception e)
			{
					System.out.println("���ڸ� �Է��Ͻʽÿ�.");
					sc.nextLine();
			}
		}
				

			
			while(true){
				System.out.println("�ɸ��׽�Ʈ2)");
				System.out.println("���� �����ٺ��� ���� �տ�");
				System.out.println("���ڳ� ���ְ� ����� ���������� ���� �ֽ��ϴ�.");
				System.out.println("���� ������ ���̴� �󸶿����� ���ڽ��ϱ�?(m)");
				sol2 = sc.nextInt();
				if(sol2<0)System.out.println("�ٽ� �Է��Ͻʽÿ�.");
				else break;
			}
			System.out.println("�ɸ��׽�Ʈ3)");
			System.out.println("�������� ������ ���� �����ϴ�.");
			System.out.println("ù��° �湮�� ����� �̹��� ����");
			System.out.println("�Ͼ������ �Ǿ��ִ� ���̿����ϴ�.������ ������ �Ͼ���Դϴ�.");
			System.out.println("�̹��� ó�������� �ڽ��� ������ �������.");
			sol3 = sc.next();

			while(true){
				System.out.println("�ɸ��׽�Ʈ4)");
				System.out.println("��. �����湮�� ����ڽ��ϴ�.");
				System.out.println("�̹��濡�� â���� ħ��,������ �ֽ��ϴ�.");
				System.out.println("����� â���� ������Ͱ�, ħ�뿡 �����������Ͱ�, ���嵵 ������ͽ��ϴ�.");
				System.out.println("��� ���� ���� �Ͻðڽ��ϱ�?");
				sol4 = sc.nextLine();
				System.out.println();
				if(sol4.contains("â��") || sol4.contains("ħ��") || sol4.contains("����"))
					break;
				else System.out.println("�ٽ� �Է��Ͻʽÿ�");
					
			}
			System.out.println("�ɸ��׽�Ʈ5)");
			System.out.println("��. �׷� â���� �����ٰ� ������ ���ڽ��ϴ�.");
			System.out.println("â���� ����� �ۿ� �������� ���Դϴ�.");
			System.out.println("�� �����忡�� ����� ������ �������ϰ� �ֽ��ϴ�.");
			System.out.println("�̶� ����� �ൿ��??");
			sol5 = sc.nextLine();
			System.out.println();

			System.out.println("�ɸ��׽�Ʈ6)");
			System.out.println("�� �׷� ������ ���� ����ٽ��ϴ�.");
			System.out.println("���������� ��û ��Ӱ� įį�� ���Դϴ�.");
			System.out.println("��𼱰� Ŀ���⵵���°� ������.");
			System.out.println("�̹濡 �� ����� �ൿ��??");
			sol6 = sc.nextLine();
			System.out.println();

			System.out.println("");
			System.out.println("======�ɸ��׽�ũ ����� �˷��帮�ڽ��ϴ�.======");
			if(sol<2) System.out.println("���踦 �ֿ� ����� ��鼭 ������ �ٶ���ֱ��䤻������");
			else System.out.println("���踦 ���� ���� ����� ��鼭 ������ �ٶ�������ʰ� ������ ��ư��±���.");
			System.out.println("----------------------------------------------------------------------");			
			System.out.println("����� ������ ���� ���̴� "+sol2+"m�� ����.");
			System.out.println("�� ���̰� ������̼��� ���� �������� �����Դϴ�.");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("�Ͼ�� ���� �� ����� ���� "+sol3+"��(��)");
			System.out.println("����� ���� ó���¾���� ���� �����Դϴ�.");
			System.out.println("----------------------------------------------------------------------");			
			if(win.equals(sol4.charAt(0)))
				System.out.println("â���� ������ ����� ����ڸ� ������ �׻���� ����� ���� �� ������.");
			else if(bad.equals(sol4.charAt(1)))
				System.out.println("ħ�븦 ������ ����� ����ڸ� ������ �׻���� ����� ���� �� ������.");
			else
				System.out.println("������ ������ ����� ����ڸ� ������ �׻�� ��ü�� ���� �� ������.");
			
			System.out.println("----------------------------------------------------------------------");
			if(sol5.contains("�ƹ��͵�"))
				System.out.println("����� ����ڰ� �ܵ��� �Ͽ��� �� �ƹ��͵� ���� ���� �� ������.");
			else if(sol5.contains("����"))
				System.out.println("����� ����ڰ� �ܵ��� �Ͽ��� �� ���� �ܵ� �Ұ� ������.");
			else if(sol5.contains("�θ�"))
				System.out.println("����� ����ڰ� �ܵ��� �Ͽ��� �� �ٽ� ���ƿ����� �Ұ� ������.");			
			else if(sol5.contains("����"))
				System.out.println("����� ����ڰ� �ܵ��� �Ͽ��� �� ��� �ϴ��� ���Ѻ� �� ������.");
			
			System.out.println("----------------------------------------------------------------------");
			if(sol6.contains("�ƹ��͵�") || sol6.contains("��") )
				System.out.println("����� ����� ������ �տ� ������ ������ �޾Ƶ��� �� �����ϴ�.");
			else{
				System.out.println("����� ����� ������ �տ� ������ �����ϸ� ������ �޾Ƶ����� ���� �� �����ϴ�.");
				}
			System.out.println("----------------------------------------------------------------------");
			while(true){
				System.out.println("�ٽ� �Ͻðڽ��ϱ�??(y/n)");
				yn = sc.next();
				if(yn.equals("n")){
						b=false;
						break;
					}else if(yn.equals("y")){
						b=true;
						break;
					}else{}
			}
		}//while�� �ݱ�.
	}
}