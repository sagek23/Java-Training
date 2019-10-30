/*
사용자에게 핸드폰 번호를 입력받아 올바른 핸드폰 번호인지 판단
xxx-xxxx-xxxx
*/
import java.util.*;
class  CellphoneNum1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("핸드폰 번호를 입력하세요==> ");
		String pNum = sc.next();
		
		if (pNum.length()!=13)
		{
			System.out.println("잘못된 번호입니다");
			return;
		}
		boolean flag = true;
		int n = 0; //하이픈의 개수를 구하기 위한 것
		for (int i=0;i<pNum.length() ;i++ )
		{
			if(pNum.charAt(i) == '-')
				n++;
		}
		if (n!=2)
			flag =false; //n이 2가 아니면 flag에 false를 넣고 탈출하여 맨 아래 if문으로 간다.

		int start = pNum.indexOf("-");
		int end = pNum.lastIndexOf("-");

		if (start !=3|| end !=8)
			flag = false; ////start나 end기 3과 8이 아니면 flag에 false를 넣고 탈출하여 맨 아래 if문으로 간다.

		for(int i=0; i<pNum.length();i++)
		{	
			if (i==3 || i==8)
				continue;
			if(!Character.isDigit(pNum.charAt(i)))
			{	flag=false;  //i의 캐릭터가 숫자가 아니면 flag에 false를 저장하고 탈출
				break;
			}
		}
                                                                                                                                                                                                                                                                                                           
		if (flag) //a의 길이가 3, b와c는 4이면 올바른 번호
			System.out.println("올바른 번호입니다");
		else
			System.out.println("잘못된 번호입니다");
	
	}
}
