class Person
{
	String name;
	int age;
	public Person() //������ �ߺ�����
	{
	}
	public Person(String n, int a)
	{
		name = n;
		age = a;
	}


}
class PersonTest6
{
	public static void main(String[] args) 
	{
		Person p = new Person("ȫ�浿", 20); //�⺻�����ڸ� ����ϴ� ���� �ƴϸ� �ݵ�� �Ű������� �����
		Person p1 = new Person();
		System.out.println("�̸�: "+p.name);
		System.out.println("����: "+p.age);
		System.out.println(p1.name);
		System.out.println(p1.age);
	}
}
/*
����ڰ� �����ڸ� ����� �ڹٴ� ���̻� �⺻ �����ڸ� �������� �ʴ´�. 
���� �⺻�����ڰ� �ʿ��ϴٸ� �����ڸ� �ߺ������Ѵ�.
*/