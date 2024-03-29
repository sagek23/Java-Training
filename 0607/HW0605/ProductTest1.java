class Product
{
	protected String name;
	protected double price;

	public Product()
	{
	}
	public Product(String name, double price)
	{
		this.name = name;
		this.price = price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public double getPrice()
	{
		return price;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public String toString()
	{
		return "이름: "+name+" 가격: "+price;
	}
}	
class DiscountProduct extends Product
{
	private double discount;
	public DiscountProduct()
	{	
	}
	public DiscountProduct(String name, double price, double discount)
	{
		super(name,price);
		this.discount=discount;
	}
	public void setDiscount(double discount)
	{
		this.discount = discount;
	}
	public double getDiscount()
	{
		return discount;
	}
	public double getPrice()
	{
		return price*(1-(0.01*discount));
	}
	public String toString()
	{
		return super.toString()+"할인가: "+ getPrice();
	}
}
class  ProductTest1
{
	public static void main(String[] args) 
	{
		Product p1 = new Product("toothbrush", 3000);
		Product p2 = new DiscountProduct("toothbrush", 3000, 15); 
		System.out.println(p1.getPrice());
		System.out.println(p2.getPrice());
		System.out.println(p2);
	}
}
