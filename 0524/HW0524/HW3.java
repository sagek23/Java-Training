/*1. ������ ���� ���α׷��� �ۼ�. ���� ����ڷκ��� �ϳ��� ���ڸ� �Է¹���.
�̾ ����ڷκ��� 2���� ���ڸ� �Է¹���. ����ڷκ��� �Է¹��� ���ڰ� '+'
�̸� �� ���� ����, ���ڰ�'-'�̸� ����, ���ڰ�'X'�̸� ����, ���ڰ� '/'�̸�
�������� ����. if-else�� ���. �������� ���, �и� 0�� �ƴ��� �˻�*/
import java.util.*;
class  HW3
{
	public static void main(String[] args) 
	{	
		Scanner sc = new Scanner(System.in);
		System.out.print("+, -, X, / �� �ϳ��� �Է��Ͻÿ�==> ");
		String cal = sc.next();
		System.out.print("ù��° ��==>");
		int a = sc.nextInt();
		System.out.print("�ι�° ��==>");
		int b = sc.nextInt();
		int result = 0;

		if (cal.equals("+"))
			result=a + b;
		else if (cal.equals("-"))
			result=a - b;
		else if (cal.equals("X"))
			result=a * b;
		else if (cal.equals("/"))
			if(b==0)
				System.out.println("0 �̿��� ���� �Է��Ͻÿ�");
			while (true)
				{
					System.out.print("�ι�° ��==>");
					b = sc.nextInt();
					if(b!=0)
						break;
				}
			result=a / b;

			
		System.out.println(result);
		
	



	}
}
