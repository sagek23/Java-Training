/*
����ڿ��� �ֹι�ȣ�� �Է¹޾� ����ϰ��� �׸��� ���.
<< ó������ >>
���̰� 40�� �̻��̰� �����̸�
	����, ����
���̰� 40�� �̻��̰� �����̸�
	����, ����, �ڱþ�, �����
���̰� 50�� �̻��̰� �����̸�
	����, ����, �����
���̰� 50�� �̻��̰� �����̸�
	����, ����, �����, �ڱþ�, �����
*/
import java.util.*;
class  HW1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Date year = new Date();
		int tYear = year.getYear()+1900;
		System.out.println("--����ϰ���Ȯ��--");
		System.out.print("�ֹι�ȣ�� �Է��ϼ���==> ");
		String sNum = sc.next();
		int mm = Integer.parseInt(sNum.charAt(13)+"");
		int sum=0;
		int plus=2;
		int z = 0;
		for (int i = 0;i<sNum.length()-1;i++)
		{
			if (plus==10)
				plus=2;
			if (i==6)
				continue;
			z = Integer.parseInt(sNum.charAt(i)+"");
			sum+=plus*z;
			plus++;
		}
		int right = 11-(sum%11);

		String num = sNum.substring(0,2);//���̸� ����ϱ����� �⵵�� ������ ex)91
		String age = "19"+num; //�⵵�տ� 19�� ����
		int a = Integer.parseInt(age); //���ڿ� age�� ���ڷ� ��ȯ. ��⵵ ������ ���ϴ� ��
		String gender = sNum.substring(7,8); //-���� ù��° ���� �ϳ��� ������(���� �Ǻ��� ����)
		int g = Integer.parseInt(gender);  //���� gender�� ���ڷ� ��ȯ
		String r = "����, ����";
		if (mm==right)
			if (tYear-a>=40 && tYear-a<50)
				{	
						if (g==2||g==4)
							r = r+", �ڱþ�, �����";
							System.out.println(r+" ������� ����Դϴ�");
				}
			else if (tYear-a>=50)
				{	
					r = r+", �����";
						if (g==2||g==4)
							r = r+", �ڱþ�, �����";
							System.out.println(r+" ������� ����Դϴ�");
				}
				else
					System.out.println("����ϰ��� ����� �ƴմϴ�");
		
		else
			System.out.println("�߸��� �ֹι�ȣ�Դϴ�");
	}
}
