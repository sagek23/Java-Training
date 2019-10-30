import java.util.*;
class CellPhone
{
	private String modelName;
	private String manufacture;
	private String color;
	private String onOff;
	private String camera;
	public void setModelName(String m)
	{
		modelName=m;
	}
		public void setManufacture(String ma)
	{
		manufacture=ma;
	}
		public void setColor(String co)
	{
		color=co;
	}
		public void setOnOff(String o)
	{
		onOff=o;
		if (onOff=="On")
			onOff="Off";
		else
			onOff="On";
	}
		public void setCamera(String ca)
	{
		camera=ca;
	}
		public String getModelName()
	{
		return modelName;
	}
		public String getManufacture()
	{
		return manufacture;
	}
		public String getColor()
	{
		return color;
	}
		public String getOnOff()
	{
		return onOff;
	}
	public String getCamera()
	{
		return camera;
	}
	public CellPhone()
	{
		this("iPhone xs max", "Apple", "Zet Black", "On", "Yes");
	}
	public CellPhone(String modelName, String manufacture, String color, String onOff, String camera)
	{
		this.modelName=modelName;
		this.manufacture=manufacture;
		this.color=color;
		this.onOff=onOff;
		this.camera=camera;
	}
	public String toString()
	{
		return "�𵨸�: "+modelName+" ������: "+manufacture+" ����: "+color+" ����: "+onOff+" ī�޶�: "+camera;
	}
	public void power() //toggle �¿��� �ݺ�
	{
		if(onOff=="On")
			onOff="Off";
		else
			onOff="On";
	}


}
class	CellPhoneTest  
{
	public static void main(String[] args) 
	{
		CellPhone c1 = new CellPhone();
		//System.out.println(c1.manufacture);
		//System.out.println(c1.onOff);
		//c1.setModelName("iPhone");
		//System.out.println("�𵨸�: "+c1.getModelName());
		c1.setOnOff("On");
		System.out.println("����: "+c1.getOnOff());
		c1.power();
		System.out.println(c1);
		c1.power();
		System.out.println(c1);
	}
}