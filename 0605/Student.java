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
	public static void main(String[] args)
	{
		Human h = new Human();
		System.out.println("hello");
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
	public static void main(String[] args)
	{
		System.out.println("��Ʈ");
	}
}
class  HumanTest 
{
	public static void main(String[] args) 
	{
		//Human h = new Human(); //�θ�Ŭ������ �⺻�����ڸ� �������� ������ ���� �Ұ�.
		Human h1 = new Human("����",18);
		Human h2 = new Human("����",21);
		System.out.println(h1);
		/*��ü�� ��¹��� ǥ���� �� �� Ŭ������ toString�� �ִٸ� toString��
		�ڵ�ȣ��ȴ�. toString�� ���ٸ� �ּҰ� ���*/
		System.out.println(h2.toString());
		Student s1 = new Student("����", 21,"��ǻ�Ͱ���");
		Student s2 = new Student("����", 22,"�濵��");
		Student s3 = new Student("����", 24,"�����ξ�");
		System.out.println(s1.toString());
		System.out.println(s2);
		System.out.println(s3);



	}
}