/*
�迭�� ���ο� �����͸� �߰��ϱⰡ ����
���ο� �θ��� ������ �߰� 24,25
*/
class  AppendArray
{
	public static void main(String[] args) 
	{
		int sum=0;
		int age;
		int []ages ={26,30,26,27,32,20}; 
		int []arr = new int[ages.length+2];
		int i = 0;
		for (i=0;i<ages.length ;i++ )
		{	
			arr[i] = ages[i];
		}

		arr[i++] = 24;
		arr[i] = 25;

		System.out.println("����: ");
		for (int d:arr) //for each �ݺ���
		{
			System.out.print(d+" ");
		}
		System.out.println();
		
	}
}
