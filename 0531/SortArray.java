class SortArray 
{
	public static void main(String[] args) 
	{
		int []ages = {26,30,20,40,25};
		//[20][25][26][30][40]이 되도록 하기 i:0
		for (int i=0;i<ages.length ;i++ )
		{
			for (int j=i+1;j<ages.length ;j++ )
			{
				if (ages[j] < ages[i])
				{
					int temp = ages[i]; //ages[i]의 값이 더 크면 temp에 ages[i]의 값을 저장
					ages[i] = ages[j]; //ages[j]의 값을 ages[i]에 넣어서 순서를 바꿈
					ages[j] = temp; //temp에 넣어놓은 ages[i]의 값을 ages[j]에 넣음.
				}
			}
		}
		for (int i=0;i<ages.length ;i++ )
			System.out.println(ages[i]+"");
	}
}
