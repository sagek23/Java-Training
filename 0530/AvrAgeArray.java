/*팀원들의 나이를 배열에 저장하고
나이의 총합과 평균을 구하여 출력
팀원은 모두 6명이고 각강의 나이는
26, 30, 26, 27, 32, 20
*/
class  AvrAgeArray
{
	public static void main(String[] args) 
	{
		int sum=0;
		int age;
		//int []age ={26,30,26,27,32,20}; 
		int []ages = new int[6];
		ages[0]=26;
		ages[1]=30;
		ages[2]=26;
		ages[3]=27;
		ages[4]=32;
		ages[5]=20;
		//ages[6]=50; 배열의 범위를 초과하므로 오류
		for (int i=0;i<ages.length ; i++)
		{
			age = ages[i];
			sum +=age;
		}
		int avr = sum/ages.length;
		System.out.println("나이 총합: "+sum);
		System.out.println("나이 평균: "+avr);
	}
}
