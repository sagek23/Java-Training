class StringEquals3
{
	public static void main(String[] args) 
	{
		String a = "Hello ";
		String b = " Hello";
		a = a.trim();
		b = b.trim();
		if(a.equals(b))
			System.out.println("같아요");
		else
			System.out.println("달라요");
	}
}
