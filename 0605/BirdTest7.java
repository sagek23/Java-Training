class Bird
{
	protected String type;
	protected boolean wing;
	protected String color;
	public Bird(String type, boolean wing, String color)
	{
		this.type = type; //�����ڸ� ����� �� �̻� �⺻�����ڸ� �������� �����Ƿ� ������ ����.
		this.wing = wing;
		this.color = color; 
	}
}
class Plane extends Bird //Bird�� ������ ��ӹ޾� ��밡��
{
	private boolean engine;
		
	public Plane()
	{
		super("A380",true,"��"); 
	}
	public String toString()
	{
		return "����: "+engine;
	}
}
class  BirdTest7
{
	public static void main(String[] args) 
	{
		Plane p = new Plane(); //�⺻������ �䱸. ���������� Bird�� �⺻�����ڵ� �䱸��.
		/*Plane Ŭ���������� ����ڰ� �����ڸ� �������� �ʾ� �⺻Ŭ������ ����������
		Plane�� �θ�Ŭ������ Bird���� ����ڰ� �����ڸ� �����Ͽ� �⺻Ŭ������ ���� ����
		�ε� Plane��ü ������ Bird�� �⺻�����ڸ� �䱸�Ͽ� ������ ����.
		�����ذ��� ���ؼ��� Plane�� �⺻�����ڸ� �����Ͽ� �� �ȿ��� Bird�� �´� �����ڸ�
		�䱸�Ѵ�.
		PlaneŬ���� �ȿ� super("A380",true,"��"), Ȥ�� Bird�� �⺻�����ڸ� �����.*/
		System.out.println(p.toString());
	}
}
