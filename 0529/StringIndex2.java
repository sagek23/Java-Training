class StringIndex2
{
	public static void main(String[] args) 
	{
		String str = "Hello java hello korea hello java";
		int n = str.indexOf("java"); //a가 처음 나오는 자리의 번호를 알려준다
		System.out.println(n);
		int n2 = str.indexOf("java", 8); //8번째 자리 이후의 a를 찾는다
		System.out.println(n2);
	}
}
