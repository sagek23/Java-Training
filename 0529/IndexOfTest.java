class IndexOfTest 
{
	public static void main(String[] args) 
	{
		String a = "Hello";
		int n = a.indexOf("e");
		System.out.println(n);
		int n2 = a.indexOf("k");
		System.out.println(n2); //문자열이 없으면 -1을 출력하므로 그 문자열이 포함되어있는지 검사할 수 있다
	}
}
