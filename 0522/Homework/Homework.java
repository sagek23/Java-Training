/* 사용자 한테 0~99사이의 정수를 입력받아 
		한글표기식 출력하는 프로그램을 작성합니다.
         (단, if문을 100개를 사용하는 것은 아닙니다^^)*/
import java.util.*;
class Homework 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("0~99사이의 숫자를 입력하세요==> ");
		int a = sc.nextInt();
		String b = " 일이삼사오육칠팔구";
		String e = "";
		
		if(a<0 || a>100)
		{
			System.out.println("숫자를 다시 입력하세요");
			return;
		}		
		
		//사용자가 입력한 숫자로 십의 자리 수와 1의 자리 수를 구한다

		int n10 = a/10;
		int n1  = a%10;
		if (a==0)
			e = "영";
		/*else if(a>=10 && a<20)
				e = "십"+b.charAt(n1);*/ 
		else 
		{
			if (n10!=1)
			e = b.charAt(n10)+"";
			
			if(a >=10)
			{
				e = e+"십";
			}
				

			e = e+b.charAt(n1);
		}

		System.out.println(e);



	}
}


/*
char b = a.charAt(i);
			if (b == 'A')
				n = n+1;*/