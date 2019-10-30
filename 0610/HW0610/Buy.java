interface Buyable
{
	public int getPrice();
}

class Television implements  Buyable
{
	String model;
	String brand;
	int price;
	public Television()
	{
	}
	public Television(String model, String brand, int price)
	{
		this.model = model;
		this.brand = brand;
		this.price = price;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
	public String getModel()
	{
		return model;
	}
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	public String getBrand()
	{
		return brand;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public int getPrice()
	{
		return price;
	}
	public String toString()
	{
		return "모델: "+model+" 브랜드: "+brand+" 가격: "+price; 
	}
}
class  Buy
{
	public static void main(String[] args) 
	{
		Television tv = new Television("DIOS","LG", 2500000);
		System.out.println(tv);
		printPrice(tv);
	}
	private static void printPrice(Buyable item)
	{
		System.out.println(item.getPrice());
	}
}
