/*
숙제1) 사용자한테 문장을 입력받아 단어별 빈도수를 구하여 
출력하는 프로그램을 작성합니다.

<< 출력 예>>
문장을 입력하시오==>hello java hello korea
hello	: 2
java	: 1
korea	: 1
*/
import java.util.*;
class  HWMethod2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("문장을 입력하세요");
		String w = sc.nextLine();
		//String[] word = w.split(" ");
		int count = 0;
		for (int i=0;i<word.length ; i++)
		{
			if ((word[i]))
				count+=1;
		
			System.out.println(word[i]+": "+count);	
		
		}
	
		
	}
}
