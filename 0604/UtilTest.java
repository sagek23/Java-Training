/*
어떤 클래스는 속성만으로 구성될 수도 있고 
기능만으로 구성될 수도 있다.

두개의 정수를 매개변수로 전달받아 그중에 큰수를 찾아
반환하는 메소드를 갖는 클래스
*/
class Util
{
	public int getMax(int a, int b) //기능만으로 구성.
	{
		int max;
		if (a>b)
			max = a;//return a;
		else
			max = b; //return b;

		return max;
	}
}
class  UtilTest
{
	public static void main(String[] args) 
	{
		Util u = new Util(); //객체생성 시 매개변수를 주려면 생성자가 있어야함
		//u.getMax(2,3);
		System.out.println(u.getMax(10,34));
	}
}
