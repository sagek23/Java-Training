//오류1: 101~109를 넣으면 일백십땡이라고 나온다;;
//오류2: 240 이상 숫자를 넣으면 오류가 뜬다;; <<-- 이것 질문드립니다!!

import java.util.Scanner;
public class hw1_2 {
	public static void main(String []args)
	{Scanner sc = new Scanner(System.in);
	System.out.print("0에서 999 사이 정수를 입력하세요: ");
	int n = sc.nextInt();
	int m= (n/10);
	int b= (n/100);
	

	/*String이 자꾸 반복하여 갱신되므로
	 사용하지않는 쓰레기 메모리가 생겨 
	 메모리 부족현상이 일어난다*/

	String str = " 일이삼사오육칠팔구";
		for (int i=0; i<=(m); i++)
			str += str;
			if (n ==0)
				System.out.println("영");
			else if (n>0 && n<10)
				System.out.println(str.charAt(n));
			else if (n>=10 && n<100)
				System.out.println(str.charAt(m)+"십.."+str.charAt(n));
			else if (n>=100 && n<1000)
				System.out.println(str.charAt(b)+"백"+str.charAt(m)+"십.."+str.charAt(n));

			else
				System.out.println("입력값을 다시 확인하세요.");


	
	}
}
