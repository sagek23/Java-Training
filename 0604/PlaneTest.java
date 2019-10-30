class Plane
{
	private String manufacturer;
	private String model;
	private int maxPassenger;
	public static int planes;
	public Plane(String manufacturer, String model, int maxPassenger)
	{
		this.manufacturer = manufacturer;
		this.model = model;
		this.maxPassenger = maxPassenger;
		planes++;
	}
	public Plane()
	{
		this("AirBus","A380",500); //this�� ����ϹǷ� �� �̿��� �����ڸ� ȣ��. 
		//manufacturer = "AirBus";   ���� �ִ� �����ڸ� ȣ���Ͽ� ���� �����ϹǷ� 
		//model = "A360";			 ���� �ִ� �����ڿ��ִ� plane++�� �ϰ� �� ������
		//maxPassenger = 500;		 ���ִ� plane++�� �ٽ� �ѹ� �ϹǷ� �� �����ڿ�����
		planes++;				    //plane++�� ���ʿ��ϴ�
	}
	public void setManufacturer(String manufacturer)
	{
		this.manufacturer= manufacturer;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
	public void setMaxPassenger(int maxPassenger)
	{
		this.maxPassenger = maxPassenger;
	}
	public String getManufacturer()
	{
		return manufacturer;
	}
	public String getModel()
	{
		return model;
	}
	public int getMaxPassenger()
	{
		return maxPassenger;
	}
	public static int getPlanes()
	{
		return planes;
	}
}
class  PlaneTest
{
	public static void main(String[] args) 
	{
		Plane p1 = new Plane();
		Plane p2 = new Plane();
		Plane p3 = new Plane();
		//p1.setManufacturer("AirBus");
		//p2.setManufacturer("Boeing");
		//p1.setModel("A380");
		//p2.setModel("Boeing 747");
		//System.out.println("������: "+p1.getManufacturer());
		//System.out.println("��: "+p1.getModel());
		//System.out.println("������: "+p2.getManufacturer());
		//System.out.println("��: "+p2.getModel());
		System.out.println("����� ���: "+Plane.getPlanes());
	}
}