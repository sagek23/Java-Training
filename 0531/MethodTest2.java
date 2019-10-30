class  MethodTest2
{
	public static void sayHello() //메소드의 정의 
	{
		for (int i=1;i<=3 ; i++)
			System.out.println("성빈아 안녕");
		
	}

	public static void main(String[] args) 
	{
		sayHello(); //메소드 호출
		int year = 2019;
		System.out.println("올해는 "+year);
		
		sayHello();

		String name = "비트캠프";
		System.out.println("우리가 있는 곳은 "+name);
		
		sayHello();


	}
}
