class  MergeArray2 
{
	public static void main(String[] args) 
	{
		int a[]={10,20,30};
		int b[]={40,50,60,70};
		int c[] = new int[a.length+b.length];
		
		System.arraycopy(a,0,c,0,a.length);
		System.arraycopy(b,0,c,a.length,b.length);
		
		for (int i=0;i<c.length ;i++ )
		{
			System.out.println(c[i]);
		}
		
	}
}
