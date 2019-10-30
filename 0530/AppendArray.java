/*
배열에 새로운 데이터를 추가하기가 불편
새로운 두명의 데이터 추가 24,25
*/
class  AppendArray
{
	public static void main(String[] args) 
	{
		int sum=0;
		int age;
		int []ages ={26,30,26,27,32,20}; 
		int []arr = new int[ages.length+2];
		int i = 0;
		for (i=0;i<ages.length ;i++ )
		{	
			arr[i] = ages[i];
		}

		arr[i++] = 24;
		arr[i] = 25;

		System.out.println("나이: ");
		for (int d:arr) //for each 반복문
		{
			System.out.print(d+" ");
		}
		System.out.println();
		
	}
}
