//m = 11-{(2×a+3×b+4×c+5×d+6×e+7×f+8×g+9×h+2×i+3×j+4×k+5×l) % 11}
import java.util.*;
class  HW
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하시오==> ");
		String sNum = sc.next();
		
		String a = sNum.charAt(0)+"";
		String b = sNum.charAt(1)+"";
		String c = sNum.charAt(2)+"";
		String d = sNum.charAt(3)+"";
		String e = sNum.charAt(4)+"";
		String f = sNum.charAt(5)+"";
		String g = sNum.charAt(7)+"";
		String h = sNum.charAt(8)+"";
		String i = sNum.charAt(9)+"";
		String j = sNum.charAt(10)+"";
		String k = sNum.charAt(11)+"";
		String l = sNum.charAt(12)+"";
		String m = sNum.charAt(13)+"";

		int aa = Integer.parseInt(a);
		int bb = Integer.parseInt(b);
		int cc = Integer.parseInt(c);
		int dd = Integer.parseInt(d);
		int ee = Integer.parseInt(e);
		int ff = Integer.parseInt(f);
		int gg = Integer.parseInt(g);
		int hh = Integer.parseInt(h);
		int ii = Integer.parseInt(i);
		int jj = Integer.parseInt(j);
		int kk = Integer.parseInt(k);
		int ll = Integer.parseInt(l);
		int mm = Integer.parseInt(m); 

		int n = 11-(((2*aa)+(3*bb)+(4*cc)+(5*dd)+(6*ee)+(7*ff)+(8*gg)+(9*hh)+(2*ii)+(3*jj)+(4*kk)+(5*ll))%11);
		
	
	
		if (mm == n)
			System.out.println("맞는 번호입니다");
		else
			System.out.println("잘못된 번호입니다");
		

	}
}
