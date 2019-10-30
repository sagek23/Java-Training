class Bird
{
	private String type;
	private boolean wing;
	private String color;

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
			System.out.println(color+"�� "+type+"��/�� ��~��~");
		else
			System.out.println(color+"�� "+type+"��/�� �� �� ����");
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
class Plane extends Bird //Bird�� ������ ��ӹ޾� ��밡��
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
		super(type,wing,color); //�θ�Ŭ������ �ʱ�ȭ �ϵ��� �ϴ� ��. ù��° ���忡 �;���.
		this.engine=engine;
	}
	public Plane() //�⺻������
	{}
}
class  BirdTest3
{
	public static void main(String[] args) 
	{
		Plane p1 = new Plane("A380", true, "��",true);
		p1.fly();
		p1.setColor("�ϴ�");
		p1.fly();
		
	}
}
