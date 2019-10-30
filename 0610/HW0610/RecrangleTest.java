interface Filter
{
	public boolean isItOk(Object obj);
}

class Rectangle implements Filter, Comparable
{
	int width=0;
	int height=0;
	public Rectangle(int width, int height)
	{
		this.width = width;
		this.height=height;
	}
	public Rectangle()
	{
	}
	public boolean isItOk(Object obj)
	{
		Rectangle rect = (Rectangle)obj;
		if (rect.width==rect.height)
			return true;
		else
			return false;
	}
	public int compareTo(Object o)
	{
		Rectangle rect = (Rectangle)o;
		int area = width*height;
		int area2 = rect.width*rect.height;
		/*면적을 비교하여 내가 더 크면 양수 
		작으면 음수 같으면 0을 반환*/
		if(area < area2)
			return -1;
		else if(area > area2)
			return 1;
		else
			return 0;
		
	}

}

class  RecrangleTest
{
	public static void main(String[] args) 
	{
		Rectangle r = new Rectangle(10,5);
		Rectangle r1 = new Rectangle(6,6);
		r.isItOk(r);
		r1.isItOk(r1);
		r.compareTo(r1);

		System.out.println(r.isItOk(r));
	}
}
