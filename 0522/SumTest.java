class SumTest 
{
	public static void main(String[] args) 
	{
		int sum = 0;
		int i = 1;
		
		sum = sum + i; //1
		i = i + 1; //2
		
		sum = sum + i; 
		i = i + 1;

		sum = sum + i; //6
		i = i + 1; //4

		

		System.out.println(sum);
		
		System.out.println(i);
	}
}
