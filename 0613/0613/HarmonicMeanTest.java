//����ڿ��� �� ���� �Է¹޾� �μ��� ��ȭ����� ���Ͽ� ���.
import java.util.*;
class NotHarmonicMeanException extends Exception
{
	public NotHarmonicMeanException(String msg)
	{
		super(msg);
	}
}
class  HarmonicMeanTest
{
	public static void main(String[] args) //throws NotHarmonicMeanException
	{
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		int r;
		try{
			System.out.print("ù��° ���� �Է�==> ");
			a = sc.nextInt();
			System.out.print("�ι�° ���� �Է�==> ");
			b = sc.nextInt();
			if(a==-b)
			{
				throw new NotHarmonicMeanException("�� ���� ��ȭ����� ����� ");
			}

			r = (2*a*b)/(a+b);
			System.out.print("�� ���� ��ȭ���: "+r);
			}
		catch(NotHarmonicMeanException e) //Exception�� ��� ����
		{
			System.out.println(e.getMessage());
			System.out.println(e);}//� ������������ ���
	}
}