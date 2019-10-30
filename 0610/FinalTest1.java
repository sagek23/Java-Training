class A
{
	int a = 3;
	final static int YEAR=2019;
	/*다른 멤버변수와 구분하기 위해 일반적으로
	상수는 모두 대문자로 만든다
	final은 변경할 수 없는 상수를 의미.
	즉, 객체마다 별도의 메모리를 확보할 필요가 없으니
	static으로 만드는 것이 좋다*/
}
class FinalTest1 
{
	public static void main(String[] args) 
	{
		A aa = new A();
		aa.a=6;
		aa.YEAR = 2020;
		//System.out.println("Hello World!");
	}
}
