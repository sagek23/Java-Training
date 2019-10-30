class MethodTest6
{
	public static int plus(int a, int b)  //int a,b는 불가. return값이 있을때는 메소드 이름앞에 
										 //리턴하는 값의 자료형의 타입을 넣어야함. 리턴값이 없을 때는 void 
	{
		int r = a+ b;
		//System.out.println("결과: " +r);
		return + r; //리턴값이 있음
	}
	public static void main(String[] args) 
	{
		int r1 = plus(2,3);
		System.out.println("결과: "+r1);
		r1 = plus(267,3);
		System.out.println("결과: "+r1);
	}
}
