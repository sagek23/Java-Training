class ArrayIndexForEach
{
	public static void main(String[] args) 
	{
		int [] arr = {10,20,30,40,50};
		for (int i=0;i<arr.length ; i++) //���⼭ i�� arr�� index
			System.out.println(arr[i]+"");
		for(int i : arr) //���⼭ i�� arr�� ���� �������� �� i��ü�� �迭�� �ִ� value
			System.out.println(i+"");	
	}
}
