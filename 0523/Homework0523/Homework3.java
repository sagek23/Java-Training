/*
숙제3) 사용자로 부터 임의의 수 N을 입력받아 
	  그 수의 약수의 개수를 구하여 출력합니다.
*/
import java.util.*;
class  Homework3
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n을 입력하시오==> ");
		int n = sc.nextInt();
		int count=0;
		for (int i=1;i<=n ;i++ )
		{
			if (n%i==0)
				count += 1;
		}
		System.out.println(n+"의 약수의 개수는 "+count+"개");
	}
}
