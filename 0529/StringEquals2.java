class StringEquals2
{
	public static void main(String[] args) 
	{
		String a = "hello";
		String b = "Hello";
		if(a.equalsIgnoreCase(b))
			System.out.println("같아요");
		else
			System.out.println("달라요");
	}
}
