class Bird
{
	protected String type;
	protected boolean wing;
	protected String color;
	public Bird()
	{
		System.out.println("Bird�� ������ ������");
	}
}
class Plane extends Bird //Bird�� ������ ��ӹ޾� ��밡��
{
	private boolean engine;
	/*
	public Plane()
	{
		super(); �ڽ�Ŭ���� �⺻�����ڿ� �����Ǿ� ����
	}
	*/
}
class  BirdTest5
{
	public static void main(String[] args) 
	{
		Plane p = new Plane(); //�⺻������ �䱸. ���������� Bird�� �⺻�����ڵ� �䱸��.
		System.out.println("ok");
	}
}
