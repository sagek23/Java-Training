class InitialMatrix 
{
	public static void main(String[] args) 
	{
		int [][]b = {{10,20,30},
			{40,50,60},
			{70,80,90},
			{100,110,120}};  //{{첫번째줄 초기화},{두번째줄 초기화},{세번째줄 초기화}};

		//[행][열]

		int [][]c = {{10,20},{30,40,50,60},{70,80,90}};
		
		for (int i=0;i<b.length ;i++)
		{
			for (int j=0;j<3;j++ )
			{
				System.out.print(b[i][j]+"\t"); //i번째 줄에 j번째 칸
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i=0;i<c.length ;i++ )
		{
			for (int j=0;j<c[i].length;j++ ) //c[i].length --> i번째 줄의 칸수
			{
				System.out.print(c[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
}
