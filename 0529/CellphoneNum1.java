/*
����ڿ��� �ڵ��� ��ȣ�� �Է¹޾� �ùٸ� �ڵ��� ��ȣ���� �Ǵ�
xxx-xxxx-xxxx
*/
import java.util.*;
class  CellphoneNum1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�ڵ��� ��ȣ�� �Է��ϼ���==> ");
		String pNum = sc.next();
		
		if (pNum.length()!=13)
		{
			System.out.println("�߸��� ��ȣ�Դϴ�");
			return;
		}
		boolean flag = true;
		int n = 0; //�������� ������ ���ϱ� ���� ��
		for (int i=0;i<pNum.length() ;i++ )
		{
			if(pNum.charAt(i) == '-')
				n++;
		}
		if (n!=2)
			flag =false; //n�� 2�� �ƴϸ� flag�� false�� �ְ� Ż���Ͽ� �� �Ʒ� if������ ����.

		int start = pNum.indexOf("-");
		int end = pNum.lastIndexOf("-");

		if (start !=3|| end !=8)
			flag = false; ////start�� end�� 3�� 8�� �ƴϸ� flag�� false�� �ְ� Ż���Ͽ� �� �Ʒ� if������ ����.

		for(int i=0; i<pNum.length();i++)
		{	
			if (i==3 || i==8)
				continue;
			if(!Character.isDigit(pNum.charAt(i)))
			{	flag=false;  //i�� ĳ���Ͱ� ���ڰ� �ƴϸ� flag�� false�� �����ϰ� Ż��
				break;
			}
		}
                                                                                                                                                                                                                                                                                                           
		if (flag) //a�� ���̰� 3, b��c�� 4�̸� �ùٸ� ��ȣ
			System.out.println("�ùٸ� ��ȣ�Դϴ�");
		else
			System.out.println("�߸��� ��ȣ�Դϴ�");
	
	}
}
