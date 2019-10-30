class LoopBreak 
{
	public static void main(String[] args) 
	{
		int i = 1;
		for(;;)
		{	
			System.out.println("Hello World!");
			i++;
			if(i>3)
				break; //현재 이 문장이 있는 위치의 반복문 탈출
		}
		System.out.println("작업종료");
	}
}
