class StringEquals3
{
	public static void main(String[] args) 
	{
		String a = "Hello ";
		String b = " Hello";
		a = a.trim();
		b = b.trim();
		if(a.equals(b))
			System.out.println("���ƿ�");
		else
			System.out.println("�޶��");
	}
}