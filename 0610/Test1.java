class Animal
{
}
class Dog extends Animal
{
}
class Test1 
{
	public static void main(String[] args) 
	{
		//Animal a = new Animal();
		//�θ��� ���������� �ڽ�Ŭ������ ��ü ���� ����
		Animal a = new Dog();
		Dog d = new Animal();
		//�׷��� �ڽ��� ���������� �θ��� ��ü�� ������ �� ����.
		//Dog d = new Dog();
		System.out.println("Hello World!");
	}
}
