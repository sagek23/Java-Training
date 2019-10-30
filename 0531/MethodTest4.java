class  MethodTest4
{
	public static void sayHello(String name, int n) //메소드의 정의 /name은 매개변수 /n은 반복하고 싶은 숫자
	{
		for (int i=1;i<=n ; i++)
			System.out.println(name+"아/야 안녕");
		
	}

	public static void main(String[] args) 
	{
		sayHello("성빈",3); //메소드 호출
		int year = 2019;
		System.out.println("올해는 "+year);
		
		sayHello("지선",2);

		String name = "비트캠프";
		System.out.println("우리가 있는 곳은 "+name);
		
		sayHello("명섭",1);


	}
}
