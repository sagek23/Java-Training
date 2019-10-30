class Rectangle
{
	int width;
	int length;
	int calcArea()
	{
		return  width*length;	
	}
}
class  Rectanglee
{
	public static void main(String[] args) 
	{
		Rectangle r1;
		r1 =new Rectangle();
		r1.width = 5;
		r1.length = 10;
		//int area = r1.calcArea();
		System.out.println("¸éÀû: "+r1.calcArea());
	}
}
