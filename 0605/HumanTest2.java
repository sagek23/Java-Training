class Human
{
	protected String name; //�������
	protected int age;

	public Human(String name, int age) //�Ű�����
	{
		this.name = name; //this.~�� ��������� �ǹ�
		this.age = age;
		System.out.println("Human�� ������2");
	}
	public Human()
	{
		System.out.println("Human�� ������1");
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setAge(int Age)
	{
		this.age = age;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String toString()
	{
		return "�̸�: "+name+" ����: "+age;
	}
}
class Student extends Human
{
	private String major;
	public Student (String name, int age, String major)
	{
		super(name, age); //super�� �ݵ�� ù��° ���忡 �;���.
		this.major=major;
		System.out.println("Student�� ������2");
	}
	public Student()
	{
		System.out.println("Student�� ������1");
	}
	public void setMajor(String major)
	{
		this.major=major;
	}
	public String getMajor()
	{
		return major;
	}
	public String toString()
	{
		return super.toString()+" ����: "+major; //�θ��� toStringȣ��
	}	//�޼ҵ� �����ε�

}
class  HumanTest2
{
	public static void main(String[] args) 
	{
		//Human h = new Human(); //�θ�Ŭ������ �⺻�����ڸ� �������� ������ ���� �Ұ�.
		Human h1 = new Human("����",18);
		System.out.println(h1);
	

	}
}
