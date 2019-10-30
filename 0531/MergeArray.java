class MergeArray 
{
	public static void main(String[] args) 
	{
		int a[]={10,20,30};
		int b[]={40,50,60,70};
		int c[] = new int[a.length+b.length];
		for (int i=0;i<a.length ;i++ )
		{
			c[i]= a[i];
		}
		int n = a.length;
		for (int i=0;i<b.length ;i++ )
		{
			c[n++]= b[i];
		}
		
		for (int i=0;i<c.length ;i++ )
		{
			System.out.println(c[i]);
		}
		
	}
}
