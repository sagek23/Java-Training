class StringReverse
{
	public static void main(String[] args) 
	{
		String str = "hello"; 

		for (int i = str.length()-1;i>=0; i--)  //(01234)�� �ټ����̹Ƿ� ���� 5�� ���� 4�� �ʰ��ϹǷ� ����.
		{
			System.out.print(str.charAt(i));
		}
		
		

	}
}
