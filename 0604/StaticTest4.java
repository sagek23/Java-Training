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

	public static void roomInfo() //Ŭ���� �޼ҵ�. ��ü�������� ��밡��.
	{
		System.out.println("���ǽ��� "+room+"�Դϴ�"); 
		System.out.println("�̸�: "+name); //static ����� �ƴϹǷ� ���ٺҰ�
		//static �޼ҵ忡���� static������� ���� ����.
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
class StaticTest4 
{
	public static void main(String[] args) 
	{
		Student.room ="2���ǽ�";
		Student.name = "ȫ�浿";
		Student.roomInfo();
	}
}