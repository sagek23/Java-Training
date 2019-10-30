/*팀원들의 나이를 배열에 저장하고
나이의 총합과 평균을 구하여 출력
팀원은 모두 6명이고 각강의 나이는
26, 30, 26, 27, 32, 20
*/
class  AvrAgeArray2
{
	public static void main(String[] args) 
	{
		int sum=0;
		int age;
		int []ages ={26,30,26,27,32,20}; 
		System.out.println("나이: ");
		for (int j=0;j<ages.length ;j++ )
		{
			System.out.print(ages[j]+" ");
		}
		System.out.println(" ");
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
