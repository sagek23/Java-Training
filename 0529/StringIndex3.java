class StringIndex3
{
	public static void main(String[] args) 
	{
		String str = "Hello java";
		int n = str.lastIndexOf("a"); //뒤에서부터 a가 나오는 자리의 번호를 알려준다(자리의 순서는 앞에서 부터)
		System.out.println(n);
		int n2 = str.lastIndexOf("a", 8); //8번째 자리 이후의 a를 찾는다
		System.out.println(n2);
	}
}
