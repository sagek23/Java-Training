class  BreakTest2
{
	public static void main(String[] args) 
	{
		for (int i=1;i<=10 ;i++ )
		{
			System.out.println(i);
			if(i%5==0)
				break;

			switch (i)
			{
				case 1:case 2: case 3: System.out.println("a"); break;
				case 4:case 5: System.out.println("b");break;
			}
		}
		System.out.println("Á¾·á");
	}
}
