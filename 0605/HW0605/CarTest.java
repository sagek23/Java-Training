abstract class Vehicle
{
	protected int speed;
	public Vehicle()
	{
	}
	public Vehicle(int speed)
	{
		this.speed = speed;
	}
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	public int getSpeed()
	{
		return speed;
	}
	public abstract double getKiloPerLiter();
	public String printSpeed()
	{
		return speed+"";
	}
}
class Car extends Vehicle
{
	int time;
	public Car()
	{
	}
	public Car(int speed, int time)
	{
		super(speed);
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
		return speed/time;
	}
}
public class CarTest 
{
	public static void main(String[] args) 
	{
		Car c1 = new Car(100,20);
		System.out.println(c1.getKiloPerLiter());
	}
}
