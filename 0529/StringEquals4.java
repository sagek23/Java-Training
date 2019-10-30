class StringEquals4
{
	public static void main(String[] args) 
	{
		String a = "Hello ";
		String b = " Hello";
		if(a.trim().equals(b.trim()))
			System.out.println("같아요");
		else
			System.out.println("달라요");
	}
}
