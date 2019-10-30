/*
name과 age는 객체마다 별도의 메모리공간이 확보 ==> 객체 멤버변수
그러나 static키워드가 붙은 room은 객체마다 따로 메모리 공간이 잡히는
것이 아니라 하나만 확보되어 모든 객체가 공동으로 사용되는 공간이다.
이것은 객체가 생성되기 전에 메모리 공간이 확보되며, 객체없이도 사용할 
수 있다. 객체없이 사용하기 때문에 클래스 이름으로 접근하며, 클래스변수
라고 한다.
또 만약 객체가 생성되면 객체를 통해서도 사용할 수 있다.
*/
class Student
{
	String name; //name과 age만 객체. 객체 멤버변수이므로 객체를 생성해야 사용 가능
	int age;
	static String room; //클래스 멤버변수. 객체생성없이 사용가능.
	public void info()
	{
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
		System.out.println("강의실: "+room);
	}

	public static void roomInfo()
	{
		System.out.println("강의실은 "+room+"입니다");
	}
	public Student(String name, int age)
	{
		this.name = name; 
		this.age = age;
	}
	public String toString()
	{
		return "이름: "+name+" 나이: "+age+" 강의실: "+room;
	}
}
class StaticTest3 
{
	public static void main(String[] args) 
	{
		Student.room="2강의실";
		//Static을 붙히면 객체없이 공동으로 메모리사용
		Student s1 = new Student("이선정", 20);
		Student s2  = new Student("김지선", 21);
		System.out.println(s1.room);
		System.out.println(s2.room);
		s1.room ="1강의실";
		System.out.println(s1.room);
		System.out.println(s2.room); //모든 객체가 공동으로 사용하기 떄문에
									 //s2.room도 "1강의실"로 바뀐다
	}
}
