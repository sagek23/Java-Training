/*���α׷� ����� �ΰ��� ������ ���޹޾� �������� ����� ����ϴ� ���α׷�
ex) java DivTest 10 5 
*/
import java.util.*;
class  DivTest
{
	public static void main(String[] args) 
	{
		try{
		Scanner sc = new Scanner(System.in);
		int a, b, r;
		a = Integer.parseInt(args[0]);
		b = Integer.parseInt(args[1]);
		r=a/b;
		System.out.println("���: "+r);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("�������� �ʿ��� �μ��� �����Ͻÿ�");
		}catch(NumberFormatException e)
		{System.out.println("���ڸ� �Է°���");}
		catch(ArithmeticException e)
		{System.out.println("1�̻��� ���� �Է°���");}
	}
}
