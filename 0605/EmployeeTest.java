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

class EmployeeTest 
{
	public static void main(String[] args) 
	{
		Employee e = new Employee();
		System.out.println("ok");
	}
}