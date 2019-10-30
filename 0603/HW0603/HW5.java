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
		return "잡종";
	}
	public String toString()
	{
		return "이름: "+name+" 품종: "+breed+" 나이: "+age;
	}
}
class HW5 
{
	public static void main(String[] args) 
	{
		Dog d1 = new Dog();
		d1.setName("봉구");
		d1.setAge(4);
		System.out.println(d1); 

		System.out.println("이름: "+d1.getName());
		System.out.println("품종: "+d1.Dbreed());
		System.out.println("나이: "+d1.getAge());
	}
}
