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
		e1.setName("홍길동");
		e1.setPNum("010-1111-2222"); 
		e1.setWages(30000000);
		System.out.println("이름: "+e1.getName());
		System.out.println("전화번호: "+e1.getPNum()); //접근자의 값은 설정자에서 가져옴
		System.out.println("연봉: "+e1.getWages());
	}
}
