/*8. 컴퓨터와 가위바위보 게임하는 프로그램. 컴퓨터는 사용자에게 알리지 않고 가위바위보 
중에서 임의의 하나를 선택. 사용자는 프로그램의 입력안내 메시지에 따라서 3개 중에서 하나를
선택하게 된다. 사용자의 선택이 끝나면 컴퓨터는 누가 무엇을 선택하였고 누가 이겼는지 비겼는지
알려준다.*/
import java.util.*;
class HW8 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		System.out.println("가위바위보 게임. 다음 중 하나를 선택하시오");
		System.out.print("1.가위, 2.바위, 3.보==> ");
		
		int a;
		int r;
		
		while (true)
		{
			a = sc.nextInt();
			r = ran.nextInt(3)+1;
			if (a<=3 && a>0)
				break;
			else
				System.out.print("다시 입력하세요==>");
		}
		String str="";


		if (r==1)
			str = "com: 가위";
		else if (r==2)
			str="com: 바위";
		else if (r==3)	
			str="com: 보";

		if (a==r)
		{	System.out.println(str);
			System.out.println("비겼습니다");
		}
		else if (a==1 && r==3)
		{
			System.out.println(str);
			System.out.println("YOU WIN");
		}
		else if (a==1 && r==2)
		{
			System.out.println(str);
			System.out.println("YOU LOSE");
		}
		else if (a==2 && r==1)
		{
			System.out.println(str);
			System.out.println("YOU WIN");
		}
		else if (a==2 && r==3)
		{
			System.out.println(str);
			System.out.println("YOU LOSE");
		}
		else if (a==3 && r==1)
		{
			System.out.println(str);
			System.out.println("YOU LOSE");
		}
		else if (a==3 && r==2)
		{
			System.out.println(str);
			System.out.println("YOU WIN");
		}
	}
}



		/*
		*/