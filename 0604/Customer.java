class Customer
{
	String name;
	int age;
	public Customer(String name, int age) //생성자
	{
		this.name = name;
		this.age = age;
	}
	public String toString() //속성을 모두 출력하기위한 toString
	{
		return name+", "+age;
	}
	public static void main(String[] args) //이 main()은 Customer의 멤버메소드가 아니다.
	{									   //Customer안에 main()을 표현할 수 있다.
		Customer c = new Customer("김만두", 7);
		System.out.println(c);
	}
}
