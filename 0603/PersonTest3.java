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
class  PersonTest3
{
	public static void main(String[] args) 
	{
		Person p1 = new Person();
		p1.setName("ȫ�浿");
		p1.setBloodType("0��");
		p1.eat("����");
		p1.move("��");

		System.out.println("�̸�: "+p1.getName());
		System.out.println("������: "+p1.getBloodType());
	}
}
