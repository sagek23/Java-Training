/*������ ���� ���ǵǴ� �Լ��� �Լ����� ����Ͽ� ����. ����ڷκ��� x���� �Է�
�޾Ƽ� �Լ����� ����Ͽ� ȭ�鿡 ����Ѵ�. x�� �Ǽ��̴�*/

import java.util.*;
class  FunctionX
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�Ǽ� x�� ���� �Է��Ͻÿ�==> ");
		double x = sc.nextDouble();
		double result = 0;
		if (x<=0)
			result = (x*x*x)-(9*x)+2;
		else
			result = (7*x) +2;
		
		System.out.println("���:"+ result);
	}
}
