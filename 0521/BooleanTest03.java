class BooleanTest03
{
	public static void main(String[] args) 
	{
		/*나이를 변수에 저장하고 그 사람이 
		성인인지 아닌지 판별*/
		int age = 18;
		boolean b;
		b = age >= 20;
		if (b == true)
			System.out.println("성인입니다.");
		else
			System.out.println("성인이 아닙니다.");
	}
}
