interface Movable
{
	public abstract void speedUp(int mount);
	public abstract void speedDown(int mount);
	final int speed=100; //final�� ��������

	/*
	(�߻�Ŭ�������� �߻�޼ҵ�ܿ��� body�� �ִ� 
	�޼ҵ带 ������ �� ������, interface�� '�����߻�'
	�̹Ƿ� ��� �޼ҵ尡 body�� ������ �� ����)

	public void printSpeed()
	{
		System.out.println("���� �ӵ�: " +speed);
	}
	�� �Ұ�
	*/
}

class Car implements Movable
{
	public void speedUp(int mount)
	{//�޼ҵ� �������̵� �ÿ��� �޼ҵ��� �ñ״��İ� ������ ��ġ�ؾ���.
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
		/*�θ�Ŭ������ ���������� �ڽ�Ŭ������ ��ü�� 
		������ �� ������, �ڽ�Ŭ�������� �߰��� �������
		�ٷ� ������ �� ����. �����Ϸ��� �ڽ�Ŭ���������� 
		�� ��ȯ�� �ؾ��Ѵ�*/
	
		/*���� Movable�� �ļ��� Car�� �ƴ϶� �ٸ� ������
		���ٸ� Car�� casting �ϴ� ���� ����ϴ�. Car����
		��� �Ŀ� Casting �ؾ��Ѵ�.
		if(c instanceof Car)
			c.turnLeft();
		*/
	}

}