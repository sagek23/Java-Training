/*����ڷ� ���� �� ���� ������ �Է¹޾� ���߿� ū���� ã�� 
����ϴ� ���α׷��� �����ڷ� ���� ���ڵ��� �����ϵ��� �����մϴ�.*/
import java.util.*;
class minnum
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		int min;
		System.out.print("ù��° �� ==>");
		int a = sc.nextInt();
		System.out.print("�ι�° �� ==>");
		int b = sc.nextInt();

		if (a<b)
			min = a;
			
		else
			min = b;
		System.out.println(min);

	}
}