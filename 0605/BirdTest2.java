/*
setter
멤버변수의 값을 변경시키기 위한 메소드.
변경시키기위한 값을 매개변수로 전달받아
그것을 멤버변수에 대입한다.
*/
class Bird
{
	private String type;
	
	private String color;

	public void setType(String type)
	{
		this.type = type;
	}
	public void pro()
	{
		Scanner sc = new Scanner();
		System.out.print("새의 종류?");
		String str = sc.next;
		type = str;
	}

	
}
class  BirdTest2
{
	public static void main(String[] args) 
	{
		Bird b1 = new Bird();
		//b1.type="참새"; type이 private이므로 접근불가
		b1.setType="참새"; //setter를 사용하여 멤버변수에 값을 대입
	}
}
