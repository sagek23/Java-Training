/*정부에서는 무료 암검진을 실시하려고 한다. 
	대상자는  40세 이상인 사람들 중에 
	그해가 홀수연도 이면 홀수년도 태어나고 
	만약 그해가 짝수연도이면 짝수년도 태어난 사람이다.
        환자의 이름과 출생년도를 입력받아 
        무료암검진 대상자 인지 판별하여 출력하는 프로그램 작성.*/

import java.util.*;
class  CancerCheck3
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Date today = new Date();
		int tyear = today.getYear()+1900;
		System.out.println("**이하의 정보를 입력해 주세요**");
		System.out.print("이름을 입력해주세요==>");
		String name = sc.next();
		System.out.print("출생년도를 입력해주세요==>");
		int byear = sc.nextInt();
		int age = tyear-byear;
		if (tyear%2==byear%2 && age>=40)
			System.out.println("무료 암검진 대상자입니다");
		else
			System.out.println("무료 암검진 대상자가 아닙니다");
	}
}
