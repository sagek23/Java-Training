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
class  PersonTest4
{
	public static void main(String[] args) 
	{
		Person p1 = new Person(); //��ü������ �����ڰ� �ڵ������
	

		System.out.println("�̸�: "+p1.getName());
		System.out.println("������: "+p1.getBloodType());
	}
}
