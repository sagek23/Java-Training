/*
이번주 토요일에 구매할 로또번호 6개를 정하여 배열에 담아라.
*/
class  ArrayTest2

{
	public static void main(String[] args) 
	{
		int lotto[]= {7,8,9,15,44,38}; //자리번호는 0부터 시작. 배열의 사이즈가 n개이면 사용가능한 자리번호는 0~n-1이다.
		//배열에 처음부터 값을 넣으면 배열의 크기는 초기값만큼이 된다

		for (int i=0;i<=lotto.length-1 ;i++ )
		{
			System.out.println(lotto[i]);
		}
		
	}
}
