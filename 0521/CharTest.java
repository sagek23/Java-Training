/* 자바에서는 하나의 문자와 문자열의 처리가 다르다.
   한글자를 저장하기 위해서는 char를 사용하고 홑따옴표로 표현한다.
   예를 들어 알파벳 중에 S를 저장한다면 char a = 'S';
   문자열을 저장하기 위해서는 String을 사용하고 쌍따옴표로 표현한다.
   String b = "Korea";
*/

class CharTest 
{
	public static void main(String[] args) 
	{
		//알파벳 S를 저장하기 위한 변수선언
		char a;
		a = 'S';
		System.out.println(a);
		String b = "Korea";
		System.out.println(b);
		String c = "J";
		System.out.print(c);
		// 문자열 중에 한글자씩 뽑안오는 실험.
	}
}
