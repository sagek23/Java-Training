class StringBufferTest4
{
	public static void send(String msg)  //send�� String������ ����
	{
		System.out.println("������ �޼����� "+msg);
	}

	public static void main(String[] args) 
	{
		send("���ξ� �ȳ�");
		StringBuffer sb = new StringBuffer("Hello");
		send(sb.toString()); //StringBuffer�� send�� ����� �� �����Ƿ� String���� ��ȯ
	}
}
