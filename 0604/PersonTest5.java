class Person
{
	String name;
	int age;
	
	public Person(String n, int a)
	{
		name = n;
		age = a;
	}


}
class PersonTest5
{
	public static void main(String[] args) 
	{
		Person p = new Person("홍길동", 20); //기본생성자를 사용하는 것이 아니면 반드시 매개변수를 줘야함
		System.out.println("이름: "+p.name);
		System.out.println("나이: "+p.age);
	}
}
/*
사용자가 생성자를 만들면 자바는 더이상 기본 생성자를 제고하지 않는다. 
*/