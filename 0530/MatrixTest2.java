/*	  0 1 2
	0[][][]
	1[][][]
	2[][][]
	3[][][]

	a[0][0] = 1
	a[0][1] = 2
*/

class MatrixTest2 
{
	public static void main(String[] args) 
	{
		int [][]a = new int[4][3]; //3ĭ¥�� 4�� [��][��]
		int n=1;
		for (int i=0;i<4 ;i++)
		{
			for (int j=0;j<3 ;j++ )
				a[i][j] = n++;
		}
		System.out.println("�迭�� ��� Ȯ��");
		for (int i=0; i<4;i++ )
		{	
			for (int j=0;j<3 ;j++ )
				System.out.print(a[i][j]+"\t");
			System.out.println();
		}
	}
}
