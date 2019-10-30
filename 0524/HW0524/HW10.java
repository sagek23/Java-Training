/*11.특정한 정수를 입력받아 이 정수 사이에 있는 모든 3의 배술ㄹ 출력하는 프로그램을 작성.
만약 입력값이 0보다 작으면 오류 메시지를 출력*/
import java.util.*;
class  HW10
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("임의의 숫자를 입력하시오==> ");
		int i;
		int n = sc.nextInt();
		if (n<=0)	
				while (true)
				{
					System.out.print("0보다 큰 수를 입력하세요==> ");
					n = sc.nextInt();
					if(n!=0)
						break;
				}
			//int n = sc.nextInt();
		for (i=1;i<=n;i++)
		{
			if(i%3==0)
				System.out.println(i);
		}
	}
		
		

}


