interface Movable
{
	public abstract void speedUp(int mount);
	public abstract void speedDown(int mount);
	final int speed=100; //final은 생략가능

	/*
	(추상클래스에서 추상메소드외에는 body가 있는 
	메소드를 포함할 수 있지만, interface는 '완전추상'
	이므로 모든 메소드가 body를 포함할 수 없다)

	public void printSpeed()
	{
		System.out.println("현재 속도: " +speed);
	}
	는 불가
	*/
}

class Car implements Movable
{
	public void speedUp(int mount)
	{//메소드 오버라이딩 시에는 메소드의 시그니쳐가 완전히 일치해야함.
		System.out.println(mount);
	}

	public void speedDown(int mount)
	{
		System.out.println(mount);
	}

	public void turnLeft()
	{
		System.out.println("Turn Left");
	}
	public void turnRight()
	{
		System.out.println("Turn Right");
	}
}

class CarTest
{
	public static void main(String[] args) 
	{
		Movable c = new Car();
		c.speedUp(150);
		c.speedDown(50);
		((Car)c).turnRight();
		/*부모클래스의 참조변수가 자식클래스의 객체를 
		참조할 수 있지만, 자식클래스에서 추가된 멤버에는
		바로 접근할 수 없다. 접근하려면 자식클래스형으로 
		형 변환을 해야한다*/
	
		/*만약 Movable의 후손이 Car뿐 아니라 다른 종류도
		많다면 Car로 casting 하는 것은 곤란하다. Car인지
		물어본 후에 Casting 해야한다.
		if(c instanceof Car)
			c.turnLeft();
		*/
	}

}
