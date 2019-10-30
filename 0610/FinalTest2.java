class A
{
	public void pro()
	{
		System.out.println("pro입니다");
	}
	public final void info()
	{
		System.out.println("info입니다");
	}
}
class B extends A
{
	public void pro()
	{
		System.out.println("B의 pro입니다");
	}
	/*
	public void info()
	{
		System.out.println("B의 info입니다");
	}
	부모의 final 메소드는 재정의 불가*/ 
}
class FinalTest2 
{
	public static void main(String[] args) 
	{
		B bb = new B();
		bb.pro();
		bb.info();
	}
}
