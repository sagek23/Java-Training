/*
사람 Person(자료형)
     속성
            이름 String name        "홍길동"
	    혈액형 String bloodType "AB'

     동작   먹는다  void eat(String food)
     	    움직인다 void move(String direction)

*/
class Person
{
	private String name; //속성(멤버변수): 유지되어야될 데이터 = 필드
	private String bloodType;
	public Person() //대소문자 구분. 생성자의 이름은 클래스이름과 같아야함
	{
		name="홍길동";
		bloodType="0형";
		//생성자는 return의 개념이 없다
	}
	public String getName()
	{
		return name;
	}
	//접근자 (getter) private속성의 값을 가져오기위한 동작
	public String getBloodType()
	{
		return bloodType;
	}
	//설정자(setter)  private속성을 바꾸기위한 동작
	public void setName(String n)
	{
		name = n;
		//return은 생략가능
	}
	public void setBloodType(String b)  //return하는 값이 없으면 void
	{
		bloodType = b;
	}
	public void eat(String food) //동작(멤버메소드): 기능
	{
		System.out.println("혈액형이 "+bloodType+"인 "+name+"이/가 "+food+"를/을 먹어요" );
	}
	public void move(String direction)
	{
		System.out.println("혈액형이 "+bloodType+"인 "+name+"이/가 "+direction+"을/를 향하여 움직여요");
	}
}
class  PersonTest4
{
	public static void main(String[] args) 
	{
		Person p1 = new Person(); //객체생성시 생성자가 자동수행됨
	

		System.out.println("이름: "+p1.getName());
		System.out.println("혈액형: "+p1.getBloodType());
	}
}
