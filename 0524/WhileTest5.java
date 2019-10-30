class  WhileTest5
{
	public static void main(String[] args) 
	{
		int i = 1;
		while (i<=3)
		{
			i++; //i증가 2
			System.out.println(i);
			
		}
		System.out.println(i);
	}
}

//3까지는 3<=3이 성립하므로 while문이 실행되어 4가 출력.
//i가 4가되면 i<=3이 성립하지않으므로 탈출하여 다시 4출력