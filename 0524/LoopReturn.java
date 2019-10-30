class LoopReturn 
{
	public static void main(String[] args) 
	{
		int i = 1;
		for(;;)
		{	
			System.out.println("Hello World!");
			i++;
			if(i>3)
				return; //이 위치에서 메소드를 종료
		}
		System.out.println("작업종료");
	}
}
