class Rectanglee
{
	int width;
	int length;
	int calArea();
	{
		return  width*length;	
	}
}
class  RectangleeTest
{
	public static void main(String[] args) 
	{
		Rectanglee r1;
		r1.width = 5;
		r1.length = 10;
		r1.calcArea();
	}
}
