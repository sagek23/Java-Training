/*2. 사용자로부터 하나의 문자를 입력받아 문자가 'R'이면 사각형의 면적을, 'T'이면
삼각형의 면적을, 'C'이면 원의면적을 계산. 면적에 필요한 숫자들은 사용자로부터 
입력받음.*/
import java.util.*;
class  HW4
{
	public static void main(String[] args) 
	{	
		Scanner sc = new Scanner(System.in);
		System.out.print("R, T, C 중 하나를 입력하시오==> ");
		String cal = sc.next();
		
		double result2;
		int result=1;

		if (cal.equals("R"))
		{
			System.out.print("가로==>");
			int a = sc.nextInt();
			System.out.print("세로==>");
			int b = sc.nextInt();
			System.out.print("높이==>");
			int c = sc.nextInt();
			result2 = ((a*b)*2)+((a*c)*2)+((b*c)*2);
			result = (int)result2;
			
		}
		
		if (cal.equals("T"))
		{
			System.out.print("밑변==>");
			int d = sc.nextInt();
			System.out.print("높이==>");
			int e = sc.nextInt();
			result2 =d*e/2;
			result = (int)result2;
			
		}		
		System.out.println(result);

		if (cal.equals("C"))
		{
			System.out.print("반지름==>");
			int f = sc.nextInt();
			result2=f*3.14/2;
			System.out.println(result2);
		}
		
	}
}