/*���α׷� ����� �ΰ��� ������ ���޹޾� �������� ����� ����ϴ� ���α׷�
ex) java DivTest 10 5 
*/
import java.util.*;
class  DivTest2
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
		catch(NumberFormatException e)//���������� ����ó�� Ŭ������ ���� �´�.
		{System.out.println("�ݵ�� �ƶ��� ���ڷ� �Է��Ͻÿ�");}
		catch(Exception e)
		{System.out.println("�μ��� 1�̻��� �������� Ȯ���Ͻÿ�");}
		finally{System.out.println("�۾�����");}
	}
}