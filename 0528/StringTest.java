class StringTest 
{
	public static void main(String[] args) 
	{
		int age = 20;
		age = age+10;
		System.out.println(age);
		String a = new String("Hello"); 
		a=a+"java"; //Hello객체가 바뀌는 것이 아니라 java를 연결한 새로운 메모리가 만들어짐.
					//새로운 메모리가 생기면 원래 객체는 쓰레기가 된다.
		System.out.println(a);
	}
}
