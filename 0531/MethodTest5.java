class MethodTest5 
{
	public static void plus(int a, int b)  //int a,b는 불가
	{
		int r = a+ b;
		System.out.println("결과: " +r);
	}
	public static void main(String[] args) 
	{
		plus(2,3);
		System.out.println("더하기 잘해?");
		plus(267,3);
		System.out.println("끝");
	}
}
