class A
{
	public void pro()
	{
		System.out.println("pro�Դϴ�");
	}
	public final void info()
	{
		System.out.println("info�Դϴ�");
	}
}
class B extends A
{
	public void pro()
	{
		System.out.println("B�� pro�Դϴ�");
	}
	/*
	public void info()
	{
		System.out.println("B�� info�Դϴ�");
	}
	�θ��� final �޼ҵ�� ������ �Ұ�*/ 
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