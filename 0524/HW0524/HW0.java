/*
0000사용자에게 월을 입력받아 계절명을 출력하는 프로그램 작성.
단, 사용자가 잘못된 값을 입력하면 제대로 된 값을 입력할 때까지 
반복수행
<실행 예>
월을 입력하세요==>15
월을 입력하세요==>14
월을 입력하세요==>4
4월은 봄입니다. 
또 하시겠어요?(y/n) =>k
또 하시겠어요?(y/n) =>k
*/
import java.util.*;
class  HW0
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String season = "";
		int a;
		String b;
		while(true)
		{
			System.out.print("월을 입력하세요==>");
			a = sc.nextInt();
			if(a<=12 && a>=1)
				break;
		
		}
			switch(a)
			{
				case 12:
				case 1:
				case 2: 
					season = "겨울";
				break;

				case 3:
				case 4:
				case 5: 
					season = "봄";
				break;

				case 6:
				case 7:
				case 8: 
					season = "여름";
				break;

				case 9:
				case 10:
				case 11: 
					season = "가을";
				break;
			}
			System.out.println(season);	
				while(true)
				{
					System.out.print("다시 하시겠습니까?(y/n) ");
					b = sc.next();
					if(b.equals("y"))
						//while(true)
						//{
						//	System.out.print("월을 입력하세요==>");
						//	a = sc.nextInt();
						//	if(a<=12 && a>=1)
						break;
						//}

					else if (b.equals("n"))
					{
						System.out.println("종료합니다");
						break;	
					}
				}

	}

}
