//문자열 변수 a에 소문자 l의 갯수를 구하여 출력하시오.
class CharTest6 
{
	public static void main(String[] args) 
	{
		String a = "Hello";
		int n=0;
		for (int i=0 ; i<a.length() ; i++)
			//변수.length는 변수가 가지고 있는 문자열의 길이를 알려준다.
		{
			char b = a.charAt(i);
			if ( b == 'l' )
				n = n++;
		}
		System.out.println("소문자 l의 개수는 " + n);
	}
}
