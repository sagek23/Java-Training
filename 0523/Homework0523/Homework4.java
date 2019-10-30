/*숙제4) 사용자로 부터 임의의 수 N을 입력받아 
		그 수가 소수인지 판별하는 프로그램을 작성합니다.
       (소수는 1과 자기자신으로만 나누어 지는 수를 말합니다.
       즉 약수의 개수가 2개인 수를 말합니다.)
*/
import java.util.*;
class  Homework4
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n을 입력하시오==> ");
		int n = sc.nextInt();
		int count = 0;

		for (int i=1;i<=n ;i++ )
		{
			if (n%i==0)
			{
				count += 1;	
			}	
		}
		if(count!=2)
			System.out.println(n+"은/는 소수가 아님");
		else
			System.out.println(n+"은/는 소수");
	}
}
