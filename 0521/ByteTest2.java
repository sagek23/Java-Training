class ByteTest2 
{
	public static void main(String[] args) 
	{
		byte a;
		a = 5;
		System.out.println(a);
		a = 127;
		System.out.println(a);
		a = (byte)(a + 2);
		//byte�� ǥ���� �� ���� ���̹Ƿ� overflow �߻�
		System.out.println(a);
		
		a = -128;
		a = (byte)(a - 1);
		System.out.println(a);//underflow �߻�
	}
}