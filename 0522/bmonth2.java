/*
����) ����ڿ��� �¾ ��(month)�� �Է¹޾�
�������� ����ϴ� ���α׷��� �ۼ�.
*/
import java.util.*;
class  bmonth2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("����� �¾����?==> ");
		int month = sc.nextInt();
		String bmonth = "";
		if (month <1 || month>12)
		{	System.out.println("1~12������ ���ڸ� �Է����ּ���");
			return;
		}

			if (3<=month && month<=5)
				bmonth = "��";
		else if (6<=month && month<=8)
				bmonth = "����";
		else if (9<=month && month<=11)
				bmonth = "����";
		else
			bmonth = "�ܿ�";
			System.out.println(bmonth+"�� �¾�׿�");
		
	}
}
