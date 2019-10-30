class ArrayIndexForEach
{
	public static void main(String[] args) 
	{
		int [] arr = {10,20,30,40,50};
		for (int i=0;i<arr.length ; i++) //여기서 i는 arr의 index
			System.out.println(arr[i]+"");
		for(int i : arr) //여기서 i는 arr의 값을 가져오는 것 i자체가 배열에 있는 value
			System.out.println(i+"");	
	}
}
