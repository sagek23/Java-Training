/*��������� ������ �Է¹޾� 
	�빮�� A�� ���� ���Ͽ� ����� ���ϴ�.*/
import java.util.*;
class  UpperA
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		

		System.out.println("����� ������ �Է��ϼ���");
		String a;
		
		a = sc.nextLine();
		int n = 0;
		for (int i = 0; i<a.length() ;i++ )
		{	
			char b = a.charAt(i);
			if (b == 'A')
				n = n+1;
		}
		System.out.println("�빮�� A�� ������ "+ n);
	}
}
