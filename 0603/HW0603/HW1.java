class Rectangle
{
	private int width;
	private int length;
	int calcArea()
	{
		return  width*length;	
	}
	
	public void setWidth(int w)
	{
		width = w;
	}
	public void setLength(int l)
	{
		length = l;
	}
	public int getWidth()
	{
		return width;
	}
	public int getLength()
	{
		return length;
	}


}
class  HW1
{
	public static void main(String[] args) 
	{
		Rectangle r1 =new Rectangle();
		r1.setWidth(5);
		r1.setLength(10);
	

		System.out.println("Width: "+r1.getWidth());
		System.out.println("Length: "+r1.getLength());
		System.out.println("¸éÀû: "+r1.calcArea());
	}
}
