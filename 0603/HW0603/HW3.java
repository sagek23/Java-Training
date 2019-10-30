class	Box
{
	int width;
	int length;
	int height;
	public int getVolume()
	{
		return width*length*height;
	}
	public String toString()
	{
		return "가로: "+ width+" "+"세로: "+length+" "+ "높이: "+height;

	}
	public void setWidth(int w)
	{
		width = w;
	}
	public void setLength(int l)
	{
		length = l;
	}
	public void setHeight(int h)
	{
		height = h;
	}
	public int getWidth()
	{
		return width;
	}
	public int getLength()
	{
		return length;
	}
	public int getHeight()
	{
		return height;
	}
}
class  HW3
{
	public static void main(String[] args) 
	{
		Box box1 = new Box();
		box1.setWidth(100);
		box1.setLength(100);
		box1.setHeight(100);
		int volume = box1.getVolume();
		System.out.println("부피: "+volume);
		System.out.println(box1); //toString이 있으면 toString이 자동으로 동작. toString없으면 메모리상 위치를 출력
		Box box2 = new Box();     //객체가 가지고있는 속성값을 문자열로 표현하려면 toString을 사용.
		box2.setWidth(200);
		box2.setLength(200);
		box2.setHeight(200);
		box1 = box2; //서로 같은 메모리를 참조하도록 하는 것
		System.out.println(box1);

	}
}
