class SumTest2
{
	public static void main(String[] args) 
	{
		int sum = 0;
		int i = 1;
		
		sum = sum + i; //1
		i++; //2
		
		sum = sum + i; 
		i++;

		sum = sum + i; //6
		i++; //4

		System.out.println(sum);
		System.out.println(i);
	}
}
