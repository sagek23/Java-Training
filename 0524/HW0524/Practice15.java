/*
 * 15. �Ǻ���ġ ���������� ���� �ΰ��� ���Ҹ� ���Ͽ� 
    ���� ���Ҹ� �����.
    �Ǻ���ġ �������� ó�� ��� ���Ҹ� �����ϸ�
    ������ ����.

   0.1.1.2.3.5.8.13.21.34.55..

  f(0) = 0
  f(1) = 1
  f (i+1) = f(1) + f(i-1)  / �� i=1,2,3,....

  �Ǻ���ġ ������ �����Ͽ� ����ϴ� ���α׷���
  �ۼ��� ����. 
 */
import java.util.Scanner;
public class Practice15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("����� �Ǻ���ġ �������� �����ұ��? : ");
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
		temp: a�� ���� ����. 0
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
