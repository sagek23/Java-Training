/*5.������ �Ｎ���� ���α׷� �ۼ�. 1����� 3������� ��÷��ȣ �����Ǿ� ����.
����ڷκ��� 1~10������ ��ȣ�� �޾Ƽ� 2���� 1��, 5���� 2��, 7���� 3���̶�� ����.
��÷�� ��÷ �ȳ� �޽��� ���*/
import java.util.*;
class  HW6
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("1~10������ ��ȣ�� �Է��Ͻÿ�==> ");
		int n = sc.nextInt();
		if (n!=2 && n!=5 && n!=7)
			System.out.println("��");
			
		if (n==2)
			System.out.println("1�� ��÷");
					
		if (n==5)
			System.out.println("2�� ��÷");
					
		if (n==7)
			System.out.println("3�� ��÷");
	}
}

/*
	
if (n>=11 || n<0)
System.out.print("1~10������ ��ȣ�� �ƴմϴ�. �ٽ��Է��ϼ���==> ");
		n = sc.nextInt();
*/