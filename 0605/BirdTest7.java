class Bird
{
	protected String type;
	protected boolean wing;
	protected String color;
	public Bird(String type, boolean wing, String color)
	{
		this.type = type; //생성자를 만들면 더 이상 기본생성자를 제공하지 않으므로 에러가 난다.
		this.wing = wing;
		this.color = color; 
	}
}
class Plane extends Bird //Bird의 모든것을 상속받아 사용가능
{
	private boolean engine;
		
	public Plane()
	{
		super("A380",true,"흰"); 
	}
	public String toString()
	{
		return "엔진: "+engine;
	}
}
class  BirdTest7
{
	public static void main(String[] args) 
	{
		Plane p = new Plane(); //기본생성자 요구. 내부적으로 Bird의 기본생성자도 요구됨.
		/*Plane 클래스에세는 사용자가 생성자를 정의하지 않아 기본클래스를 제공하지만
		Plane의 부모클래스인 Bird에는 사용자가 생성자를 정의하여 기본클래스가 없는 상태
		인데 Plane객체 생성시 Bird의 기본생성자를 요구하여 에러가 난다.
		에러해결을 위해서는 Plane의 기본생성자를 정의하여 그 안에서 Bird에 맞는 생성자를
		요구한다.
		Plane클래스 안에 super("A380",true,"흰"), 혹은 Bird에 기본생성자를 만든다.*/
		System.out.println(p.toString());
	}
}
