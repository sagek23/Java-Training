/*
����ڿ��� ���� �Է¹޾� �������� ����ϴ� ���α׷� �ۼ�.
��, ����ڰ� �߸��� ���� �Է��ϸ� ����� �� ���� �Է��� ������ 
�ݺ�����
<���� ��>
���� �Է��ϼ���==>15
���� �Է��ϼ���==>14
���� �Է��ϼ���==>4
4���� ���Դϴ�. 

*/
import java.util.*;
class  SeasonWhile
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String season = "";
		int a;
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

	
	}

}