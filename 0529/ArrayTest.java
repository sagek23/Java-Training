/*
이번주 토요일에 구매할 로또번호 6개를 정하여 배열에 담아라.
*/
class  ArrayTest
{
	public static void main(String[] args) 
	{
		int lotto[]= new int[6]; //자리번호는 0부터 시작. 배열의 사이즈가 n개이면 사용가능한 자리번호는 0~n-1이다.
		lotto[0] =7;
		lotto[1] =8;
		lotto[2] =9;
		lotto[3] =15;
		lotto[4] =44;
		lotto[5] =38;

		for (int i=0;i<=lotto.length-1 ;i++ )
		{
			System.out.println(lotto[i]);
		}
		
	}
}
