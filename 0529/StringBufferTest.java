class StringBufferTest 
{
	public static void main(String[] args) 
	{
		String str = new String("Hello");
		System.out.println(str.concat("Java"));  //str�� Java�� �߰��Ǵ� ���� �ƴ϶� ��ȭ�� ���ο� ��ü�� ����� ���� ��/
		StringBuffer sb = new StringBuffer("Hello");
		System.out.println(str); //�ٽ� str�� ����Ʈ���� �� ��ȭ�� ����.
		sb.append("World"); //sb�� ������ �����. sb�� ���뿡 World�� �߰� ��.
		System.out.println(sb);
	}
}