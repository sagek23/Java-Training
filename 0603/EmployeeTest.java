class Employee 
{
	private String name;
	private String pNum;
	private int wages;
	public void setName(String n)
	{
		name = n;
	}
	public void setPNum(String p)
	{
		pNum = p;	
	}
	public void setWages(int w)
	{
		wages = w;
	}
	public String getName()
	{
		return name;
	}
	public String getPNum()
	{
		return pNum;
	}
	public int getWages()
	{
		return wages;
	}
}
class  EmployeeTest
{
	public static void main(String[] args) 
	{
		Employee e1 = new Employee();
		e1.setName("ȫ�浿");
		e1.setPNum("010-1111-2222"); 
		e1.setWages(30000000);
		System.out.println("�̸�: "+e1.getName());
		System.out.println("��ȭ��ȣ: "+e1.getPNum()); //�������� ���� �����ڿ��� ������
		System.out.println("����: "+e1.getWages());
	}
}