class StringIndex3
{
	public static void main(String[] args) 
	{
		String str = "Hello java";
		int n = str.lastIndexOf("a"); //�ڿ������� a�� ������ �ڸ��� ��ȣ�� �˷��ش�(�ڸ��� ������ �տ��� ����)
		System.out.println(n);
		int n2 = str.lastIndexOf("a", 8); //8��° �ڸ� ������ a�� ã�´�
		System.out.println(n2);
	}
}