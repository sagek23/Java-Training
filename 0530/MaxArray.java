class MaxArray 
{
	public static void main(String[] args) 
	{
		int [] arr = {54,52,50,60,15,7};
		int max;
		max = arr[0];
		for (int i=1;i<arr.length ; i++)
		{
			if (max<arr[i])
			{
				max = arr[i];
				System.out.println("가장 큰 값은 "+ max);
			}
		}
		
	}
}
