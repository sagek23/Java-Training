class ByteTest2 
{
	public static void main(String[] args) 
	{
		byte a;
		a = 5;
		System.out.println(a);
		a = 127;
		System.out.println(a);
		a = a + 1;
		//byte이 표현할 수 없는 값이므로 오류 발생
		System.out.println(a);
	}
}
