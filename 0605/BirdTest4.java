class Bird
{
	protected String type;
	protected boolean wing;
	protected String color;

	public Bird(String type, boolean wing, String color)
	{
		this.type=type;
		this.wing=wing;
		this.color=color;
	}

	public Bird()
	{
	}
	public void fly()
	{
		if(wing)
			System.out.println(color+"색 "+type+"이/가 훨~훨~");
		else
			System.out.println(color+"색 "+type+"이/가 날 수 없다");
	}
	public void setType(String type)
	{
		this.type=type;
	}
	
	public void setWing(boolean wing)
	{
		this.wing=wing;
	}
	
	public void setColor(String color)
	{
		this.color=color;
	}
	public String getType()
	{
		return type;
	}
	public boolean getWing()
	{
		return wing;
	}

	public String getColor()
	{
		return color;
	}

}
class Plane extends Bird //Bird의 모든것을 상속받아 사용가능
{
	private boolean engine;

	public void setEngine(boolean engine)
	{
		this.engine=engine;
	}
	public boolean getEngine()
	{
		return engine;
	}
	
	public Plane(String type, boolean wing, String color, boolean engine)
	{
		super(type,wing,color); //부모클래스가 초기화 하도록 하는 것. 첫번째 문장에 와야함.
		this.engine=engine;
	}
	public Plane() //기본생성자
	{}
	public void fly()
	{
		if(wing && engine) //부모의 private영역에는 접근 불가하므로 protected로 변경
			System.out.println(color+"색 "+type+"이/가 슝슝");
		else
			System.out.println(color+"색 "+type+"이/가 날 수 없다");
	}
	/*부모로부터 상속받은 기능(메소드) 중에 fly가 맘에 들지 않아
	  다시 재정의. method overriding(메소드 재정의)*/
}
class  BirdTest4
{
	public static void main(String[] args) 
	{
		Plane p1 = new Plane("A380", true, "흰",true);
		p1.fly();
		p1.setColor("하늘");
		p1.fly();
		
	}
}
