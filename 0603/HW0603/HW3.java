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
		return "����: "+ width+" "+"����: "+length+" "+ "����: "+height;

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
		System.out.println("����: "+volume);
		System.out.println(box1); //toString�� ������ toString�� �ڵ����� ����. toString������ �޸𸮻� ��ġ�� ���
		Box box2 = new Box();     //��ü�� �������ִ� �Ӽ����� ���ڿ��� ǥ���Ϸ��� toString�� ���.
		box2.setWidth(200);
		box2.setLength(200);
		box2.setHeight(200);
		box1 = box2; //���� ���� �޸𸮸� �����ϵ��� �ϴ� ��
		System.out.println(box1);

	}
}
