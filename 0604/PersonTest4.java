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
class PersonTest4
{
	public static void main(String[] args) 
	{
		Person p = new Person(); 
		//System.out.println(p.name);
		//System.out.println(p.age);
	}
}
/*
사용자가 생성자를 만들면 자바는 더이상 기본 생성자를 제고하지 않는다. 

C:\javaStudy\0604>javac PersonTest4.java
PersonTest4.java:18: error: constructor Person in class Person cannot be applied
 to given types;
                Person p = new Person();
                           ^
  required: String,int
  found: no arguments
  reason: actual and formal argument lists differ in length
1 error

*/