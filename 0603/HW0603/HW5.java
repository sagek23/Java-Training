class Dog
{
	private String name;
	public String breed;
	private int age;

	public Dog()
	{
		name = null;
		age = 0;
	}
	public void setName(String n)
	{
		name = n;
	}
	public void setAge(int a)
	{
		age = a;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return  age;
	}
	public String Dbreed()
	{
		return "����";
	}
	public String toString()
	{
		return "�̸�: "+name+" ǰ��: "+breed+" ����: "+age;
	}
}
class HW5 
{
	public static void main(String[] args) 
	{
		Dog d1 = new Dog();
		d1.setName("����");
		d1.setAge(4);
		System.out.println(d1); 

		System.out.println("�̸�: "+d1.getName());
		System.out.println("ǰ��: "+d1.Dbreed());
		System.out.println("����: "+d1.getAge());
	}
}
