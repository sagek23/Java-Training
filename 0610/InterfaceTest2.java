class A
{
	String title = "hello java";
}

interface B
{
	int year = 2019;
	public void pro();
}

interface C
{
	public void info();
}

class Bit extends A implements B, C
{
	public void pro()
	{
		System.out.println("Pro");
	}
	public void info()
	{
		System.out.println(title);
		System.out.println(year);
	}
}
class InterfaceTest2 
{
	public static void main(String[] args) 
	{
		Bit b = new Bit();
		b.pro();
		b.info();
		System.out.println("Hello World!");
	}
}
