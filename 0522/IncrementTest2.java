class IncrementTest2 
{
	public static void main(String[] args) 
	{
		int a = 8;
		int b = 8;
		int i = ++a;
		// a = a+1
		// i = a
		int j = b++;
		// j = b
		// b = b+1
		System.out.println(i);
		System.out.println(j);
		System.out.println(a);
		System.out.println(b);
	}
}
