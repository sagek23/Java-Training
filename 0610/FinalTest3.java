final class A
{
	public void pro()
	{
		System.out.println("pro�Դϴ�");
	}
}
class B extends A
{
	String title = "Java";
	public void info()
	{
		System.out.println(title);
	}
}
class FinalTest3 
{
	public static void main(String[] args) 
	{
		A aa = new B();
		aa.pro();
		((B)aa).info();
	}
}
