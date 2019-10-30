/*구구단 2단을 출력하는 프로그램을 작성*/

class  Gugudan2
{
	public static void main(String[] args) 
	{
		for (int a=2;a<=9;a++ )   //a = 2
		{
			System.out.println(a+"단");
			for (int i =1 ; i<=9 ;i++ ) //i = 1,2,3,4,5,6,7,8,9
			{		
					System.out.println(a+"*"+i+"="+(a*i));
			
			}
		}
	}
}
