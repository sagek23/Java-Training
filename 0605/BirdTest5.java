class Bird
{
	protected String type;
	protected boolean wing;
	protected String color;
	public Bird()
	{
		System.out.println("Bird의 생성자 동작함");
	}
}
class Plane extends Bird //Bird의 모든것을 상속받아 사용가능
{
	private boolean engine;
	/*
	public Plane()
	{
		super(); 자식클래스 기본생성자에 생략되어 있음
	}
	*/
}
class  BirdTest5
{
	public static void main(String[] args) 
	{
		Plane p = new Plane(); //기본생성자 요구. 내부적으로 Bird의 기본생성자도 요구됨.
		System.out.println("ok");
	}
}
