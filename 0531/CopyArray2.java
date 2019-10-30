class CopyArray2
{
	public static void main(String[] args) 
	{
		int []a ={10,20,30,40,50};
		int []b = new int [a.length];

		for (int i=0;i<a.length ;i++)
		{
			b[i] = a[i];
		}
		a[0]=100;
		
		for (int i=0;i<a.length ;i++)
		{
			System.out.println(b[i]+" ");
		}
		System.out.println();
	}
}
