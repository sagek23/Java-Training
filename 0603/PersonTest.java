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
	String name; //�Ӽ�(�������): �����Ǿ�ߵ� ������
	String bloodType;
	void eat(String food) //����(����޼ҵ�): ���
	{
		System.out.println("�������� "+bloodType+"�� "+name+"��/�� "+food+"��/�� �Ծ��" );
	}
	void move(String direction)
	{
		System.out.println("�������� "+bloodType+"�� "+name+"��/�� "+direction+"��/�� ���Ͽ� ��������");
	}
}
class  PersonTest
{
	public static void main(String[] args) 
	{
		Person p1;//Person(�ڷ���) p1(������)
		p1 = new Person(); //new�� ��ü���������ϴ� ��. Person��ü�� ����ų �� �ִ� �������� p1���� ����
		p1.name ="ȫ�浿"; //������.�Ӽ� = "";
		p1.bloodType = "O";
		p1.eat("����Ƽ"); //������.�޼ҵ�();
		p1.move("��");
		

		Person p2;
		p2 = new Person();
		p2.name = "��ö��";
		p2.bloodType = "B";
		p2.eat("���̽�ũ��");
		p2.move("�п�");

	}
}