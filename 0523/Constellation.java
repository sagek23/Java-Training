/*
����) ������� �̸�, ����, ������ �Է¹޾� ���ڸ��� �Ǻ��Ͽ� ����ϴ�
���α׷��� �ۼ��Ͻÿ�
*/
import java.util.*;
class  Constellation
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ���==> ");
		String name = sc.next();
		System.out.print("������ �Է��ϼ���==> ");
		int month = sc.nextInt();
		System.out.print("������ �Է��ϼ���==> ");
		int day = sc.nextInt();
		String star ="";

		switch (month)
		{
		case 1: 
			if (day<20)
				star = "�����ڸ�";
			else
				star = "�����ڸ�";
			break;
		case 2:
			if (day<20)
				star = "�����ڸ�";
			if (day>19)
				star = "������ڸ�";
			break;
		case 3: 
			if (day<20)
				star = "������ڸ�";
			if (day>21)
				star = "���ڸ�";
			break;
		case 4:
			if (day<20)
				star = "���ڸ�";
			if (day>19)
				star = "Ȳ���ڸ�";
			break;
		case 5:
			if (day<21)
				star = "Ȳ���ڸ�";
			if (day>20)
				star = "�ֵ����ڸ�";
			break;
		case 6:
			if (day<22)
				star = "�ֵ����ڸ�";
			if (day>21)
				star = "���ڸ�";
			break;
		case 7:
			if (day<23)
				star = "���ڸ�";
			if(day>22)
				star = "�����ڸ�";
			break;
		case 8:
			if (day<23)
				star = "�����ڸ�";
			if(day>22)
				star = "ó���ڸ�";
			break;
		case 9:
			if (day<24)
				star = "ó���ڸ�";
			if (day>23)
				star = "õĪ�ڸ�";
			break;
		case 10:
			if (day<23)
				star = "õĪ�ڸ�";
			if(day>22)
				star = "�����ڸ�";
			break;
		case 11:
			if (day<23)
				star = "�����ڸ�";
			if (day>22)
				star = "����ڸ�";
			break;
		case 12:
			if(day<25)
				star = "����ڸ�";
			if(day>24)
				star = "�����ڸ�";
			break;
			
		}
		System.out.println(name +"���� ���ڸ��� " + star +"�Դϴ�");
	}
}

