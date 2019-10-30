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
		System.out.println("매개변수를 모두 갖는 생성자 동작함");
	}
	public Plane()
	{
		this("AirBus","A380",500); 
	/*this를 사용하므로 나 이외의 생성자를 호출. 
	  위에 있는 생성자를 호출하여 값을 대입하므로 
	  위에 있는 생성자에있는 plane++를 하고 이 
	  생성자에있는 plane++를 다시 한번 하므로 
	  이 생성자에서는 plane++가 불필요하다*/

		//planes++;				    
		System.out.println("매개변수를 갖지않는 생성자 동작함");
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
		
		System.out.println("비행기 대수: "+Plane.getPlanes());
	}
}
