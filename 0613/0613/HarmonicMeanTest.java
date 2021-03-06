//사용자에게 두 수를 입력받아 두수의 조화평균을 구하여 출력.
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
			System.out.print("첫번째 수를 입력==> ");
			a = sc.nextInt();
			System.out.print("두번째 수를 입력==> ");
			b = sc.nextInt();
			if(a==-b)
			{
				throw new NotHarmonicMeanException("두 수의 조화평균은 없어요 ");
			}

			r = (2*a*b)/(a+b);
			System.out.print("두 수의 조화평균: "+r);
			}
		catch(NotHarmonicMeanException e) //Exception만 적어도 가능
		{
			System.out.println(e.getMessage());
			System.out.println(e);}//어떤 예외인지까지 출력
	}
}
