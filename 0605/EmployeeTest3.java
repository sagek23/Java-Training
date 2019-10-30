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
	public double computeSalary()
	{
		
		return salary;
	}

}
class HourlyEmployee extends Employee
{
	private double hrSalary;
	private double hour;
	public HourlyEmployee()
	{
	}
	public HourlyEmployee(String name, String num, String dept, double hrSalary, double hour)
	{
		super(name, num, dept);
		this.hrSalary = hrSalary;
		this.hour = hour;
	}
	public void setHrSalary(double hrSalary)
	{
		this.hrSalary = hrSalary;
	}
	public double getHrSalary()
	{
		return hrSalary;
	}
	public void setHour(double hour)
	{
		this.hour = hour;
	}
	public double getHour()
	{
		return hour;
	}
	public double computeSalary()
	{
		return hrSalary*hour;
	}
}
class EmployeeTest3
{
	public static void main(String[] args) 
	{
		SalariedEmployee s1 = new SalariedEmployee("천석훈","a001","개발1팀",5000000);
		System.out.println(s1.getName());
		System.out.println(s1.getNum());
		System.out.println(s1.getDept());
		System.out.println(s1.computeSalary());
		System.out.println();
		HourlyEmployee h1 = new HourlyEmployee("홍길동","a002","개발프리",50000,160);
		System.out.println(h1.getName());
		System.out.println(h1.getNum());
		System.out.println(h1.getDept());
		System.out.println(h1.computeSalary());
		
	}
}
