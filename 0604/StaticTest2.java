class Student
{
	String name;
	int age;
	String room;
	public Student(String name, int age, String room)
	{
		this.name = name;
		this.room = room;
		this.age = age;
	}
	public String toString()
	{
		return "�̸�: "+name+" ����: "+age+" ���ǽ�: "+room;
	}
}
class StaticTest2 
{
	public static void main(String[] args) 
	{
		Student s1 = new Student("�̼���", 20, "2���ǽ�");
		Student s2  = new Student("������", 21, "2���ǽ�");

		System.out.println(s1);
		System.out.println(s2);
	}
}