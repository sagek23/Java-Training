class Person
{
	String name;
	int age;
	public Person(String n, int a) //������ �ߺ�����
	{
		this.name = name;
		this.age = age;  //this�� ��������� ����
	}
	public Person()
	{
		this("ȫ�浿", 20);
		System.out.println("constructor works");
	}


}
class PersonTest9
{
	public static void main(String[] args) 
	{
		Person p = new Person(); //�⺻�����ڸ� ����ϴ� ���� �ƴϸ� �ݵ�� �Ű������� �����
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