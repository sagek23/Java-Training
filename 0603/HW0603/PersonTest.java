class Person
{
	String name;
	int age;
	public Person(String n, int a)
	{
		name = n;
		age = a;
	}
	public void info()
	{
		System.out.println("이름: "+name+" 나이: "+age);		
	}
	public String toString()
	{
		return "이름: "+name+" 나이: "+age;
	}
}
class  PersonTest
{
	public static void main(String[] args) 
	{
		Person p = new Person("홀길동", 20);
		System.out.println(p); //모든 속성을 출력하려면 toString을 사용할 것
		//p.info()
	}
}
