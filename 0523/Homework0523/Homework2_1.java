/*숙제2) 사용자로 부터 임의의 수 N을 입력받아 
		그 수의 약수를 모두 출력합니다.*/
import java.util.*;
class  Homework2_1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n을 입력하시오==> ");
		int n = sc.nextInt();
		for (int i = 1;i<=n ;i++)
		{
			if (n%i==0)
				System.out.print(i);
				if(i!=n)
					System.out.print(",");
	
		}
		
	}
}
