/*
��� Person(�ڷ���)
     �Ӽ�
            �̸� String name        "ȫ�浿"
	    ������ String bloodType "AB'

     ����   �Դ´�  void eat(String food)
     	    �����δ� void move(String direction)

*/
class Person
{
	private String name; //�Ӽ�(�������): �����Ǿ�ߵ� ������ = �ʵ�
	private String bloodType;

	
	public Person() //��ҹ��� ����. �������� �̸��� Ŭ�����̸��� ���ƾ���
	{
		name="ȫ�浿";
		bloodType="0��";
		//�����ڴ� return�� ������ ����
	}
	public Person(String n, String b)
	{
		name = n;
		bloodType = b;
	}
	public Person(String n)
	{
		name = n;
		bloodType = "A";
	}
	/*
	public Person(String b)
	{
		
		bloodType = "B";
		name = "ȫ�浿";
	} �Ұ�. ���� �����ڿ� �ڷ����� ������ ���⶧��
	*/ 
	
	public String getName()
	{
		return name;
	}
	//������ (getter) private�Ӽ��� ���� ������������ ����
	public String getBloodType()
	{
		return bloodType;
	}
	//������(setter)  private�Ӽ��� �ٲٱ����� ����
	public void setName(String n)
	{
		name = n;
		//return�� ��������
	}
	public void setBloodType(String b)  //return�ϴ� ���� ������ void
	{
		bloodType = b;
	}
	public void eat(String food) //����(����޼ҵ�): ���
	{
		System.out.println("�������� "+bloodType+"�� "+name+"��/�� "+food+"��/�� �Ծ��" );
	}
	public void move(String direction)
	{
		System.out.println("�������� "+bloodType+"�� "+name+"��/�� "+direction+"��/�� ���Ͽ� ��������");
	}
}
class  PersonTest5
{
	public static void main(String[] args) 
	{
		Person p1 = new Person("�̼���","O��"); //��ü������ �����ڰ� �ڵ������
		Person p2 = new Person("������","A");
		Person p3 = new Person(); //�Ű����� ����
		Person p4 = new Person("���켺"); //�Ű����� �Ѱ�
		p1.eat("����");
		p2.eat("���̽�ũ��");
		p3.eat("����");
		p4.eat("������");

	//	System.out.println("�̸�: "+p1.getName());
		//System.out.println("������: "+p1.getBloodType());
	}
}