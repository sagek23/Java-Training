/*
����ڿ��� ���� �Է¹޾� �������� ����϶�
switch���� ����� ��
*/
import java.util.*;
class  Season
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �Է��ϼ���==> ");
		int month = sc.nextInt();
		String season="";
		

		switch (month)
		{
			case 12: case 1: case 2:
				season = "�ܿ�";
				break;
			case 3:
			case 4:		
			case 5:
				season ="��";
				break;			
			case 6:
			case 7:
			case 8:
				season ="����";
				break;
			case 9:
			case 10:
			case 11:
				season = "����";
				break;
			default: //== if���� else
				season = "�߸��� �� �Դϴ�";
		}
		System.out.println(season);
	}
}

/*case�� �ȿ� if���� �� �� ����*/