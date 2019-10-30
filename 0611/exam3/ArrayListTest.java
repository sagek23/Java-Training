package exam3;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Person> al = new ArrayList<Person>();
		al.add(new Person(20,"È«±æµ¿"));
		al.add(new Person(30,"ÀÌµµ"));
		for (Person p:al)
		{
			p.sayHello();
		}
		/*
		ArrayList al = new ArrayList();
		al.add("È«±æµ¿");
		al.add(2019);
		al.add(true);
		al.add(new Person(20,"È«±æµ¿"));
		for (Object obj:al)
		{
			((Package)ob).sayHello();
		}
		*/
	}

}
