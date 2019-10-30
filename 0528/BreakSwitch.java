class BreakSwitch 
{
	public static void main(String[] args) 
	{
		int n =2;
		switch (n)
		{
			case 1:
			case 2:
				System.out.println("1이거나 2입니다");
				break;
			case 3:
			case 4:
				System.out.println("3이거나 4입니다");
				break;
		}
		System.out.println("종료");
	}
}
