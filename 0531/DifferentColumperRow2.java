class DifferentColumperRow2
{
	public static void main(String[] args) 
	{
		int [][]b = new int[3][];
		b[0] = new int[4];
		b[1] = new int[2];
		b[2] = new int[6];
		int n = 1;
		/* �� �迭�� ��ҿ� 1���� 1�� ������ ���� ���ʷ� ������ �� ���
		   [1][2][3][4]
		   [5][6]
		   [7][8][9][10][11][12]
		*/

		for (int i=0;i<b.length;i++)
		{
			for (int j=0;j<b[i].length ;j++ )  //b[i].length�� ĭ��
			{
				b[i][j]=n++;
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
		
		
	}
}
