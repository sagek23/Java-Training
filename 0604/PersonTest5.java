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
		Person p = new Person("ȫ�浿", 20); //�⺻�����ڸ� ����ϴ� ���� �ƴϸ� �ݵ�� �Ű������� �����
		System.out.println("�̸�: "+p.name);
		System.out.println("����: "+p.age);
	}
}
/*
����ڰ� �����ڸ� ����� �ڹٴ� ���̻� �⺻ �����ڸ� �������� �ʴ´�. 
*/