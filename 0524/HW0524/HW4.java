/*2. ����ڷκ��� �ϳ��� ���ڸ� �Է¹޾� ���ڰ� 'R'�̸� �簢���� ������, 'T'�̸�
�ﰢ���� ������, 'C'�̸� ���Ǹ����� ���. ������ �ʿ��� ���ڵ��� ����ڷκ��� 
�Է¹���.*/
import java.util.*;
class  HW4
{
	public static void main(String[] args) 
	{	
		Scanner sc = new Scanner(System.in);
		System.out.print("R, T, C �� �ϳ��� �Է��Ͻÿ�==> ");
		String cal = sc.next();
		
		double result2;
		int result=1;

		if (cal.equals("R"))
		{
			System.out.print("����==>");
			int a = sc.nextInt();
			System.out.print("����==>");
			int b = sc.nextInt();
			System.out.print("����==>");
			int c = sc.nextInt();
			result2 = ((a*b)*2)+((a*c)*2)+((b*c)*2);
			result = (int)result2;
			
		}
		
		if (cal.equals("T"))
		{
			System.out.print("�غ�==>");
			int d = sc.nextInt();
			System.out.print("����==>");
			int e = sc.nextInt();
			result2 =d*e/2;
			result = (int)result2;
			
		}		
		System.out.println(result);

		if (cal.equals("C"))
		{
			System.out.print("������==>");
			int f = sc.nextInt();
			result2=f*3.14/2;
			System.out.println(result2);
		}
		
	}
}