//m = 11-{(2×a+3×b+4×c+5×d+6×e+7×f+8×g+9×h+2×i+3×j+4×k+5×l) % 11}
import java.util.*;
class  HW2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하시오==> ");
		String sNum = sc.next();
		int i;
		int a = 2;
		int sum = 0;
		int mm = Integer.parseInt(sNum.charAt(13)+"");
		
		int z = 0;

		for (i=0;i<sNum.length()-1 ;i++ )
		{
			if (a == 10)
				a = 2;
			if(i==6)
				continue;
			
		
			z = Integer.parseInt(sNum.charAt(i)+"");
			sum += a*z;
			a++;

		}
			
			int w = 11-(sum%11);
			

			if (w==mm)
				System.out.println("맞는 번호입니다");
			else
				System.out.println("잘못된 번호입니다");
				

		
		

	}
}
