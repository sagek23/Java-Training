class SortArray 
{
	public static void main(String[] args) 
	{
		int []ages = {26,30,20,40,25};
		//[20][25][26][30][40]�� �ǵ��� �ϱ� i:0
		for (int i=0;i<ages.length ;i++ )
		{
			for (int j=i+1;j<ages.length ;j++ )
			{
				if (ages[j] < ages[i])
				{
					int temp = ages[i]; //ages[i]�� ���� �� ũ�� temp�� ages[i]�� ���� ����
					ages[i] = ages[j]; //ages[j]�� ���� ages[i]�� �־ ������ �ٲ�
					ages[j] = temp; //temp�� �־���� ages[i]�� ���� ages[j]�� ����.
				}
			}
		}
		for (int i=0;i<ages.length ;i++ )
			System.out.println(ages[i]+"");
	}
}
