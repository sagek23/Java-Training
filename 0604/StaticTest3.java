/*
name�� age�� ��ü���� ������ �޸𸮰����� Ȯ�� ==> ��ü �������
�׷��� staticŰ���尡 ���� room�� ��ü���� ���� �޸� ������ ������
���� �ƴ϶� �ϳ��� Ȯ���Ǿ� ��� ��ü�� �������� ���Ǵ� �����̴�.
�̰��� ��ü�� �����Ǳ� ���� �޸� ������ Ȯ���Ǹ�, ��ü���̵� ����� 
�� �ִ�. ��ü���� ����ϱ� ������ Ŭ���� �̸����� �����ϸ�, Ŭ��������
��� �Ѵ�.
�� ���� ��ü�� �����Ǹ� ��ü�� ���ؼ��� ����� �� �ִ�.
*/
class Student
{
	String name; //name�� age�� ��ü. ��ü ��������̹Ƿ� ��ü�� �����ؾ� ��� ����
	int age;
	static String room; //Ŭ���� �������. ��ü�������� ��밡��.
	public void info()
	{
		System.out.println("�̸�: "+name);
		System.out.println("����: "+age);
		System.out.println("���ǽ�: "+room);
	}

	public static void roomInfo()
	{
		System.out.println("���ǽ��� "+room+"�Դϴ�");
	}
	public Student(String name, int age)
	{
		this.name = name; 
		this.age = age;
	}
	public String toString()
	{
		return "�̸�: "+name+" ����: "+age+" ���ǽ�: "+room;
	}
}
class StaticTest3 
{
	public static void main(String[] args) 
	{
		Student.room="2���ǽ�";
		//Static�� ������ ��ü���� �������� �޸𸮻��
		Student s1 = new Student("�̼���", 20);
		Student s2  = new Student("������", 21);
		System.out.println(s1.room);
		System.out.println(s2.room);
		s1.room ="1���ǽ�";
		System.out.println(s1.room);
		System.out.println(s2.room); //��� ��ü�� �������� ����ϱ� ������
									 //s2.room�� "1���ǽ�"�� �ٲ��
	}
}
