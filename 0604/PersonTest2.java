class Person
{
	String name;
	int age;
	/*
	public Person()
	{
	}

	이 기본생성자로 제공되나 생략되어있음 
	*/

}
class PersonTest2
{
	public static void main(String[] args) 
	{
		Person p = new Person(); //기본생성자가 제공되어서 매개변수 없이 객체생성 가능
		System.out.println(p.name);
		System.out.println(p.age);
	}
}
