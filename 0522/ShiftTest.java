class ShiftTest 
{
	public static void main(String[] args) 
	{
		int a = 8; //8을 이진수로 만들어 주어진 비트 수만큼 이동
				   /* ex) 8의 이진수는 1000. 이것을 왼쪽으로 
				   한비트 이동하면 10000이므로 16. 오른쪽으로
				   한비트 이동하면 100이므로 4이다*/ 
		int i = a << 1;
		System.out.println(i);
		int j = a >> 1;
		System.out.println(j);
	}
}
