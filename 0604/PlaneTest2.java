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
		System.out.println("�Ű������� ��� ���� ������ ������");
	}
	public Plane()
	{
		this("AirBus","A380",500); 
	/*this�� ����ϹǷ� �� �̿��� �����ڸ� ȣ��. 
	  ���� �ִ� �����ڸ� ȣ���Ͽ� ���� �����ϹǷ� 
	  ���� �ִ� �����ڿ��ִ� plane++�� �ϰ� �� 
	  �����ڿ��ִ� plane++�� �ٽ� �ѹ� �ϹǷ� 
	  �� �����ڿ����� plane++�� ���ʿ��ϴ�*/

		//planes++;				    
		System.out.println("�Ű������� �����ʴ� ������ ������");
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
class  PlaneTest2
{
	public static void main(String[] args) 
	{
		Plane p1 = new Plane();
		Plane p2 = new Plane();
		
		System.out.println("����� ���: "+Plane.getPlanes());
	}
}
