/*
����) ��������� 0~9������ ������ �Է¹޾�
�ѱ�ǥ��� ����ϴ� ���α׷��� �ۼ�
<���� ��>
0~9������ ���� �Է� =>8
��
*/
import java.util.*;
class  ElseIfTest1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("0~9������ ���ڸ� �Է��ϼ���==> ");
		int a = sc.nextInt();

		String r=""; //�� ������ else�� �ƴѰ�� ������ ����. ���� ������������ ���¿��� ��µ� �� �����Ƿ�.
		
		if (a==0)
			r = "��";
		else if (a==1)
			r = "��";
		else if (a==2)
			r = "��";
		else if (a==3)
			r = "��";
		else if (a==4)
			r = "��";
		else if (a==5)
			r = "��";
		else if (a==6)
			r = "��";
		else if (a==7)
			r = "ĥ";
		else if (a==8)
			r = "��";
		else if (a==9)
			r = "��";
		else 
			r = "������ �ʰ��Ͽ����ϴ�";

		System.out.println(r);
	}
}
