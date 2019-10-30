/*
1. 정수형 변수 a를 선언
2. a에 1을 대입
3. a를 출력
4. 논리형 변수 b를 선언
5. a가 1인지 판별하여 논리값을 b에 대입
6. b를 출력
*/
import java.util.*;
class  AB
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("임의의 숫자를 입력==> ");
		int a = sc.nextInt();
		System.out.println(a);
		boolean b = (a==1)?true:false;
		System.out.println(b);
	}
}
