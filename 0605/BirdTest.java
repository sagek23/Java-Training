class Bird
{
	private String type;
	private boolean canFly;
	private boolean canEat;
	private String color;

	public Bird(String type, boolean canFly, boolean canEat, String color)
	{
		this.type=type;
		this.canFly=canFly;
		this.canEat=canEat;
		this.color=color;
	}

	public Bird()
	{
		
	}
	public void setType(String type)
	{
		this.type=type;
	}
	
	public void setCanFly(boolean canFly)
	{
		this.canFly=canFly;
	}
	public void setCanEat(boolean canEat)
	{
		this.canEat=canEat;
	}
	public void setColor(String color)
	{
		this.color=color;
	}
	public String getType()
	{
		return type;
	}
	public boolean getCanFly()
	{
		return canFly;
	}
	public boolean getCanEat()
	{
		return canEat;
	}
	public String getColor()
	{
		return color;
	}
	public void fly()
	{
		if (canFly==true)
			System.out.println(color+" "+type+"��/�� "+"��~��~");
		else
			System.out.println(color+" "+type+"��/�� "+"�� �� ����");
	}	
	//public String toString()
	//{
	//	return "����: "+ type + " ����: "+canFly+" �Ŀ�: "+canEat+" ��: "+color;
	//}
	public String toString()
	{
		String r = "����: "+type;
		if(canFly)
			r = r+ ", �� �� ����";
		else 
			r = r+ ", �� �� ����";
		
		return ;
		
	}
}
class  BirdTest
{
	public static void main(String[] args) 
	{
		Bird b1 = new Bird("������", true, false, "������");
		Bird b2 = new Bird("����", true, false, "����");
		System.out.println(b1);
		System.out.println(b2);
		b1.fly();
		b2.fly();
	}
}