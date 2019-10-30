class StringReverse
{
	public static void main(String[] args) 
	{
		String str = "hello"; 

		for (int i = str.length()-1;i>=0; i--)  //(01234)의 다섯자이므로 길이 5가 오면 4를 초과하므로 에러.
		{
			System.out.print(str.charAt(i));
		}
		
		

	}
}
