class StringIndex 
{
	public static void main(String[] args) 
	{
		String str = "Hello java";
		int n = str.indexOf("a"); //a�� ó�� ������ �ڸ��� ��ȣ�� �˷��ش�
		System.out.println(n);
		int n2 = str.indexOf("a", 8); //8��° �ڸ� ������ a�� ã�´�
		System.out.println(n2);
	}
}