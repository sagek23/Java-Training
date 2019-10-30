/*
숙제5) 1~1000까지의 수 중에 완전수를 모두 출력합니다.
	(완전수란 자기자신을 제외한 약수의 합이 자신과 
		동일한 수를 말합니다.)

	예) 6의 약수 중에 자신을 제외한 약수들의 합
	1+2+3 = 6
*/
class Homework5  
{
	public static void main(String[] args) 
	{
		
		int i; 
		for (i=1;i<=1000 ; i++)  // i = 4일 경우
		{	
			int sum = 0;
			for (int j=1;j<i ;j++ ) /*중첩반복문에서 안에 있는 for은 for문장이 끝나면 다시 처음 값으로 돌아감*/
			{	
				if (i%j == 0)      //j = 1,2,3
					sum += j;     //sum = 3
			} 
			if ( sum == i)		 //sum!=4 다시 처음의 for반복문(바깥 for)으로. 
			System.out.println(i);
		}
		

	}
}
