class Human
{
	protected String name; //멤버변수
	protected int age;

	public Human(String name, int age) //매개변수
	{
		this.name = name; //this.~는 멤버변수를 의미
		this.age = age;
		System.out.println("Human의 생성자2");
	}
	public Human()
	{
		System.out.println("Human의 생성자1");
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setAge(int Age)
	{
		this.age = age;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String toString()
	{
		return "이름: "+name+" 나이: "+age;
	}
}
class Student extends Human
{
	private String major;
	public Student (String name, int age, String major)
	{
		super(name, age); //super는 반드시 첫번째 문장에 와야함.
		this.major=major;
		System.out.println("Student의 생성자2");
	}
	public Student()
	{
		System.out.println("Student의 생성자1");
	}
	public void setMajor(String major)
	{
		this.major=major;
	}
	public String getMajor()
	{
		return major;
	}
	public String toString()
	{
		return super.toString()+" 전공: "+major; //부모의 toString호출
	}	//메소드 오버로딩

}
class  HumanTest2
{
	public static void main(String[] args) 
	{
		//Human h = new Human(); //부모클래스가 기본생성자를 설정하지 않으면 설정 불가.
		Human h1 = new Human("춘향",18);
		System.out.println(h1);
	

	}
}
