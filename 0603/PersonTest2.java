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
class  PersonTest2
{
	public static void main(String[] args) 
	{
		Person p1;
		p1 = new Person();
		p1.setName("홍길동");
		p1.setBloodType("0형");
		p1.eat("젤리");
		p1.move("집");
	}
}
