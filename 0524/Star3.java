/*
다음과 같이 동작하는 프로그램을 작성
n을 입력하시오==>
*
**
***
****
*****
*/
import java.util.*;
class  Star3
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n을 입력==> ");
		int n = sc.nextInt();
		for (int i=1;i<=n ;i++ )  //i는 줄수
		{
			for (int j=1;j<=i ;j++) //j는 칸수. for문을 완전히 빠져나가면 j는 다시 1이 됨
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

/*만약 n이 3일경우 i==1이므로 1<=3.
그 안에서 j =1; i=1이므로 1<=1이므로 한번*찍고 j++한다.
j=2; i=1;이 되어 2<=1은 성립하지 않으므로 안쪽의 for 문을 
탈출하여 ()을 출력하고 i++를 해준다.
i는 증가하여 i=2;가 되고 2<=3이므로 안쪽의 for 문을 다시 실행한다.
j=1; i=2;이므로 1<=2이므로 한번*찍고 j++한다.
j=2; i=2;는 2<=2로 *을 한번 더 찍으므로 **가 된다.
j=3; i=2;는 3<=2이므로 성립하지않으므로 탈출하여 ()을 출력한다.
이하 반복*/