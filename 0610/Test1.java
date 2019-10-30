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
		//부모의 참조변수는 자식클래스의 객체 참조 가능
		Animal a = new Dog();
		Dog d = new Animal();
		//그러나 자식의 참조변수가 부모의 객체를 참조할 수 없다.
		//Dog d = new Dog();
		System.out.println("Hello World!");
	}
}
