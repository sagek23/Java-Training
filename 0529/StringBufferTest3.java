class StringBufferTest3
{
	public static void main(String[] args) 
	{
		StringBuffer sb = new StringBuffer("Hello");
		char []arr = {'k','o','r','e','a'};
		sb.append(arr);
		System.out.println(sb);

		/*StringBuffer������ �۵������ʴ� String������ ������ ����� ����.
		�׷���� StringBuffer�� String���� ���� �� �� ����� ����Ѵ�.
		*/
		String r = sb.toString(); //StringBuffer�� String���� ��ȯ
		System.out.println(r.toUpperCase());// toUpperCase�� String������ ����.
	}
}