class InitialMatrix 
{
	public static void main(String[] args) 
	{
		int [][]b = {{10,20,30},
			{40,50,60},
			{70,80,90},
			{100,110,120}};  //{{ù��°�� �ʱ�ȭ},{�ι�°�� �ʱ�ȭ},{����°�� �ʱ�ȭ}};

		//[��][��]

		int [][]c = {{10,20},{30,40,50,60},{70,80,90}};
		
		for (int i=0;i<b.length ;i++)
		{
			for (int j=0;j<3;j++ )
			{
				System.out.print(b[i][j]+"\t"); //i��° �ٿ� j��° ĭ
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i=0;i<c.length ;i++ )
		{
			for (int j=0;j<c[i].length;j++ ) //c[i].length --> i��° ���� ĭ��
			{
				System.out.print(c[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
}