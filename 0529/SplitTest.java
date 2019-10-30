class  SplitTest
{
	public static void main(String[] args) 
	{
		String kittens = "만두,벨로,까미,치즈"; 
		String []splitt = kittens.split(","); //하나의 문자열을 분리해서 배열에 넣는다.
		System.out.println(splitt.length); //배열의 길이
		System.out.println(splitt[0]);
		System.out.println(splitt[1]); 
		System.out.println(splitt[2]); 
		System.out.println(splitt[3]); 

	}
}
