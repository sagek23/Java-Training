class Point
{
	int x;
	int y;
	public Point() //constructor ������
	{
		x = 100;
		y = 300;
	}
	public int getX()
	{
		return x;
	}
	public void setX(int xCoord)
	{
		x = xCoord;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int yCoord)
	{
		y = yCoord;
	}
	public void xy() //����(����޼ҵ�): ���
	{
		System.out.println("x: "+x+" y: "+y );
	}
}
public class HW2
{
	public static void main(String[] args) 
	{
		Point p1 = new Point();
		Point p2 = new Point();
		p1.setX(100);
		p1.setY(200);
		p2.xy();
		System.out.println("xCoord: "+p1.getX());
		System.out.println("yCoord: "+p1.getY());
		System.out.println(p2.getY());

	}
}
