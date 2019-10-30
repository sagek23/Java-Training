interface Vehicle
{
	public double getKiloPerLiter();
	public void printSpeed();
	int SPEED=100;
}
class Car implements Vehicle
{
	int time;
	public Car()
	{
	}
	public Car(int SPEED, int time)
	{
		this.time = time;
	}
	public void setTime(int time)
	{
		this.time = time;
	}
	public int getTime()
	{
		return time;
	}
	public double getKiloPerLiter()
	{
		return SPEED/time;
	}
	public void printSpeed()
	{
		System.out.println("�ӵ�: "+SPEED);
	}

}
public class CarTest 
{
	public static void main(String[] args) 
	{
		Car c1 = new Car(100,20);
		System.out.println(c1.getKiloPerLiter());
		c1.printSpeed();
	}
}
