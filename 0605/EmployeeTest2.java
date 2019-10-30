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
	
	/*
	EmployeeTest2.java:43: error: SalariedEmployee is not abstract and does not over
	ride abstract method computeSalary() in Employee
	class SalariedEmployee extends Employee
	�߻�Ŭ������ ��ӹ޾Ҵٸ� �ݵ�� �߻�޼ҵ带 �������ؾ��Ѵ�. ���������� �����߻�.
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