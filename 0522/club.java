/* 
연습) 여기는 신촌의 물좋은 나이트클럽입니다. 
물관리를 위하여 나이와 키를 읿력받아 출입제한을
하려고 합니다. 나이가 35살이하이고 키는 140이상이면 
"입장가능"을 출력하고 그렇지않으면 "입장불가능"을
출력하도록 합니다
*/

import java.util.*;
class  club
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하여 주십시오 ==> ");
		int age = sc.nextInt();
		System.out.print("키를 입력하여 주십시오 ==> ");
		int height = sc.nextInt();
		
		if (age<=35 & height>=140)
		
			System.out.print("입장가능");
		else
			System.out.print("입장 불가능");

	}
}
