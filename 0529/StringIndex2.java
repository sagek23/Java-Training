class StringIndex2
{
	public static void main(String[] args) 
	{
		String str = "Hello java hello korea hello java";
		int n = str.indexOf("java"); //a�� ó�� ������ �ڸ��� ��ȣ�� �˷��ش�
		System.out.println(n);
		int n2 = str.indexOf("java", 8); //8��° �ڸ� ������ a�� ã�´�
		System.out.println(n2);
	}
}
