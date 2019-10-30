class Person
{
	protected String name;
	protected String adrs;
	protected String tel;

	public Person()
	{
	}
	public Person(String name, String adrs, String tel)
	{
		this.name = name;
		this.adrs = adrs;
		this.tel = tel;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setAdrs(String adrs)
	{
		this.adrs = adrs;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	public String getName()
	{
		return name;
	}
	public String getAdrs()
	{
		return adrs;
	}
	public String getTel()
	{
		return tel;
	}
}
class Customer extends Person
{
	private String cNum;
	private int mile;
	public Customer()
	{
	}
	public Customer(String name, String adrs, String tel, String cNum, int mile)
	{
		super(name,adrs,tel);
		this.cNum = cNum;
		this.mile = mile;
	}
	public void setCNum(String cNum)
	{
		this.cNum = cNum;
	}
	public String getCNum()
	{
		return cNum;
	}
	public void setMile(int mile)
	{
		this.mile = mile;
	}
	public int getMile()
	{
		return mile;
	}
	public String toString()
	{
		return "이름: "+name+" 주소: "+adrs+" 전화번호: "+tel+" 고객번호: "+cNum+" 마일리지: "+mile;
	}
}
class  PersonTest
{
	public static void main(String[] args) 
	{
		Customer c1 = new Customer("홍길동","서울시 마포구 백범로","010-1234-5678","hk123456",5230);

		System.out.println(c1.getName());
		System.out.println(c1.getAdrs());
		System.out.println(c1.getTel());
		System.out.println(c1.getCNum());
		System.out.println(c1.getMile());
		System.out.println();
		System.out.println(c1);

	}
}
