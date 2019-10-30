//피보나치 수열을 생성, 출력하는 프로그램을 작성
// 피보나치 수열이란, 앞의 두 원소를 합 한 값이 뒤의 원소가 되는 수열

class Weekend03_15{
	public static void main(String []args){

		int a=0, b=1, c=0;
		System.out.print( a + " " + b + " " ); 
		
		while(true) {   //while( c<=2147483647 ) 왜 이 범위로 설정해서 출력해도 같은 결과가 나올까?
			c = a + b;

			//if(c>Integer.MAX_VALUE)
			if(c<0)
				break;
			System.out.println( c + " " );
			a = b;
			b = c;
			try{
			Thread.sleep(100);
		}catch(Exception e){}

		// if ( c<=2147483647 ) 이렇게 출력하면, 0 1 1까지만 출력 됨. 왜 그럴까, int 범위 검색해서 범위까지 출력한건데.. 학원가서 확인하자..질문하자..
			// break;
		
		} // while(true)로 계속 출력하면, -가 뜸, int 범위를 초과해서 그런듯, 임의로 범위까지만 출력되게 수정하고 싶었는데..	
	}
}