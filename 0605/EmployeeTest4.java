abstract class Employee //�߻�޼ҵ尡 �ϳ��� ������ Ŭ������ �߻�Ŭ������ �Ǿ����.
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
	//�߻�޼ҵ带 ���� ���� �߰�ȣ�� ���� ����
}	//��üȭ��������(body)�� ���� �޼ҵ�� ��üȭ(�ν��Ͻ�ȭ) �� �� ����.
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
class EmployeeTest4
{
	public static void main(String[] args) 
	{
		//�θ�Ŭ������ ���������� �ڽ�Ŭ������ ��ü�� ������ �� �ִ�.
		Employee e = new HourlyEmployee();
		System.out.println("ok");
	}
}
