/*
다음과 같이 동작하는 프로그램을 while문을 이용하여 작성
<실행예>
구구단 중에 몇단을 출력할까요? 2
2*1 = 2
..
*/
import java.util.*;
class  WhileGugu
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("구구단 몇단을 출력할까==> ");
		int n = sc.nextInt();
		int i = 1;
		while(i <= 9)
		{
			System.out.println(n+"*"+i+"="+(n*i));
			i++;
		}
	}
}
