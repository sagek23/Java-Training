class Person
{
	String name;
	int age;
	public Person(String n, int a) //생성자 중복정의
	{
		name = n;
		age = a;
	}
	public Person()
	{
		this("홍길동", 20);
		System.out.println("constructor works");
	}


}
class PersonTest8
{
	public static void main(String[] args) 
	{
		Person p = new Person(); //기본생성자를 사용하는 것이 아니면 반드시 매개변수를 줘야함
		Person p1 = new Person();
		System.out.println("이름: "+p.name);
		System.out.println("나이: "+p.age);
		System.out.println(p1.name);
		System.out.println(p1.age);
	}
}
/*
사용자가 생성자를 만들면 자바는 더이상 기본 생성자를 제공하지 않는다. 
만역 기본생성자가 필요하다면 생성자를 중복정의한다.

*/