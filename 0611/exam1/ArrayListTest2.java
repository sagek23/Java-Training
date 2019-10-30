package exam1;

import java.util.ArrayList;

class Bird
{
	String name;
	String color;
	public Bird(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}
	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void fly()
	{
		System.out.println(color+"색 "+ name+"이/가 훨훨");
	}
	@Override
	public String toString() {
		return "Bird [name=" + name + ", color=" + color + "]";
	}
	
}
class Person
{
	String name;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	public void sayHello()
	{
		System.out.println("안녕 "+name);
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

public class ArrayListTest2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();
		Person p = new Person();
		al.add(new Bird("독수리","갈"));
		al.add(new Person("길동이",20));
		
		
		//Bird b = new Bird("독수리","갈색");
		//System.out.println(al);
		/*
		for(int i=0;i<al.size();i++)
		{
			Object obj = al.get(i); //Object에 담는 이유는 어떤 자료형을 받을지 모르기 때문.
									//Object는 최상위 객체이기때문에 모든 것을 참조할 수 있음.
			if (obj instanceof Person)
				((Person)obj).sayHello();
			else
				((Bird)obj).fly();
		}
		*/
		for(Object obj:al)
		{
			if (obj instanceof Person)
				((Person)obj).sayHello();
			else if (obj instanceof Bird)
				((Bird)obj).fly();
		}
	}

}
