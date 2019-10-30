//팀원들의 평균나이를 구하라
class StringAvr 
{
	public static void main(String[] args) 
	{
		String age = "26,27,30,40,41,21";
		String []ages = age.split(",");//split을 사용하여 분리한 결과는 배열이 된다.
		int sum=0; //나이의 합
		int avr; //나이의 평균
		int a; //ages를 정수로 바꾼 것
		int mem=ages.length;
		String b; //age를 ,를 기준으로 split한 것.
		for (int i=0; i<ages.length ;i++ ) 
		{
			b = ages[i];
			a = Integer.parseInt(b);	
			sum+=a;
		}
		avr = sum/mem;
		System.out.println(avr);
	
	}
}

	//ages[0].trim();배열에서 트림을 사용하려면 이렇게 사용.