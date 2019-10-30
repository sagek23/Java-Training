import java.util.*;
class SNumber 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호 입력==> ");
		String sNum = sc.next();
		boolean flag = true;
		if (sNum.length()!=14)
			flag = false;

		int d[]={2,3,4,5,6,7,8,9,2,3,4,5};
		int sum=0;
		for (int i=0;i<sNum.length()-1 ;i++ )
		{
			if (i==6)
				continue;
			sum = sum+d[i]*Integer.parseInt(sNum.charAt(i)+"");
		}
		sum = sum%11;
		sum = 11-sum;
		int mm = Integer.parseInt(sNum.charAt(13)+"");
		if (sum!=mm)
			flag = false;

		if (flag==false)
		{
			System.out.println("올바른 주민번호가 아닙니다")
			return;
		}
	}
}
