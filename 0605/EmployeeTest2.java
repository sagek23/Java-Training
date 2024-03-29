abstract class Employee //추상메소드가 하나라도 있으면 클래스도 추상클래스가 되어야함.
{						
	protected String name;
	protected String num;
	protected String dept;
	
	public Employee(String name, String num, String dept)
	{
		this.name=name;
		this.num=num;
		this.dept=dept;
	}
	public Employee()
	{
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setNum(String num)
	{
		this.num=num;
	}
	public String getNum()
	{
		return num;
	}
	public void setDept(String dept)
	{
		this.dept=dept;
	}
	public String getDept()
	{
		return dept;
	}
	public abstract double computeSalary();
	//추상메소드를 만들 때는 중괄호도 주지 않음
}	//구체화되지않은(body)가 없는 메소드는 객체화(인스턴스화) 될 수 없음.
class SalariedEmployee extends Employee
{
	private double salary;
	public SalariedEmployee()
	{
	}
	public SalariedEmployee(String name, String num, String dept, double salary)
	{
		super(name,num,dept);
		this.salary=salary;
	}
	public void setSalary(double salary)
	{
		this.salary=salary;
	}
	public double getSalary()
	{
		return salary;
	}
	
	/*
	EmployeeTest2.java:43: error: SalariedEmployee is not abstract and does not over
	ride abstract method computeSalary() in Employee
	class SalariedEmployee extends Employee
	추상클래스를 상속받았다면 반드시 추상메소드를 재정의해야한다. 하지않으면 에러발생.
	*/
}
class HourlyEmployee extends Employee
{
}
class EmployeeTest2
{
	public static void main(String[] args) 
	{
		
	}
}
