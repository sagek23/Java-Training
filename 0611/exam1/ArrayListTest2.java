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
		System.out.println(color+"�� "+ name+"��/�� ����");
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
		System.out.println("�ȳ� "+name);
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
		al.add(new Bird("������","��"));
		al.add(new Person("�浿��",20));
		
		
		//Bird b = new Bird("������","����");
		//System.out.println(al);
		/*
		for(int i=0;i<al.size();i++)
		{
			Object obj = al.get(i); //Object�� ��� ������ � �ڷ����� ������ �𸣱� ����.
									//Object�� �ֻ��� ��ü�̱⶧���� ��� ���� ������ �� ����.
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
