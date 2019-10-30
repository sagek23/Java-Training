abstract class Book
{
	protected int number;
	protected String title;
	protected String author;
	public Book()
	{	
	}
	public Book(int number, String title, String author)
	{
		this.number = number;
		this.title = title;
		this.author = author;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
	public int getNumber()
	{
		return number;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return title;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getAuthor()
	{
		return author;
	}
	public boolean equals(Object obj)
	{
		if (this.number == number)
			return true;
		else
			return false;
	}
	public String toString()
	{
		return "������ȣ: "+number+" ����: "+title+" ����: "+author;
	}
	public abstract int getLateFees();
}
class Novel extends Book
{
	int late;
	public int getLateFees()
	{
		return late*300;
	}
	public Novel()
	{
	}
	public Novel(int number, String title, String author, int late)
	{
		super(number,title,author);
		this.late = late;
	}
	public void setLate(int late)
	{
		this.late=late;
	}
	public int getLate()
	{
		return late;
	}
	public String toString()
	{
		return super.toString()+" ��ü�ϼ�: "+late+" ��ü��: "+ getLateFees();
	}
}
class Poet extends Book
{
	int late;
	public int getLateFees()
	{
		return late*200;
	}
	public Poet()
	{
	}
	public Poet(int number, String title, String author, int late)
	{
		super(number,title,author);
		this.late = late;
	}
	public void setLate(int late)
	{
		this.late=late;
	}
	public int getLate()
	{
		return late;
	}
	public String toString()
	{
		return super.toString()+" ��ü�ϼ�: "+late+" ��ü��: "+ getLateFees();
	}
}
class ScienceFiction extends Book
{
	int late;
	public int getLateFees()
	{
		return late*600;
	}
	public ScienceFiction()
	{
	}
	public ScienceFiction(int number, String title, String author, int late)
	{
		super(number,title,author);
		this.late = late;
	}
	public void setLate(int late)
	{
		this.late=late;
	}
	public int getLate()
	{
		return late;
	}
	public String toString()
	{
		return super.toString()+" ��ü�ϼ�: "+late+" ��ü��: "+ getLateFees();
	}
}
class  BookTest
{
	public static void main(String[] args) 
	{
		Novel n1 = new Novel(12343,"�ȷ�Ȩ��","�ڳ� ����", 4);
		System.out.println(n1);
		Poet p1 = new Poet(45678,"���� ���� �ʸ� ����", "������",2);
		System.out.println(p1);
	}
}
