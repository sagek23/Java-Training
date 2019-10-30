/*
 * 15. 피보나치 수열에서는 앞의 두개의 원소를 합하여 
    뒤의 원소를 만든다.
    피보나치 수열에서 처음 몇개의 원소를 나열하면
    다음과 같다.

   0.1.1.2.3.5.8.13.21.34.55..

  f(0) = 0
  f(1) = 1
  f (i+1) = f(1) + f(i-1)  / 단 i=1,2,3,....

  피보나치 수열을 생성하여 출력하는 프로그램을
  작성해 보자. 
 */
import java.util.Scanner;
public class Practice15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("몇번쨰 피보나치 수열까지 생성할까요? : ");
		int n = sc.nextInt();

		int a=0;
		int b=1;
		int temp;

		if (n>=1) 
			System.out.print(a+" ");		
		if (n>=2) 
			System.out.print(b+" ");
		/*
		a:0 b:1 i:3 
		temp: a의 값을 저장. 0
		a = 1,
		b = 0+1

		i:4
		a+b =2
		temp = 1
		a = 1
		b = 2

		i:5
		a+b = 3
		team= 1
		a = 2
		b = 3

		*/
		for (int i =  3 ; i <=n ; i++) {
			System.out.print((a+b)+" ");
			temp = a;
			a = b;
			b = temp+b;

		}


	}

}
