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
		System.out.println("�̸�: "+name+" ����: "+age);		
	}
	public String toString()
	{
		return "�̸�: "+name+" ����: "+age;
	}
}
class  PersonTest
{
	public static void main(String[] args) 
	{
		Person p = new Person("Ȧ�浿", 20);
		System.out.println(p); //��� �Ӽ��� ����Ϸ��� toString�� ����� ��
		//p.info()
	}
}
