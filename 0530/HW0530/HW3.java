import java.util.*;
class  HW3
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int []count = new int[26];
		String []alphabet = {"a","b","c","d","e","f","g","h","i","j"
			,"k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		System.out.println("문자열을 입력하시오");
		String buffer = sc.nextLine();
		buffer = buffer.toLowerCase(); //String만 사용가능
		for (int i=0;i<buffer.length() ;i++ )
		{
			char ch = buffer.charAt(i); //'a' = 97 'b' = 98
			//Character.toLowerCase(ch)로하면 String이 아니어도 toLower(Upper)Case가 가능
			if (ch == ' ')
				continue;
			count[ch-'a']++;  //a를 넣으면 97-97 = 0으로 배열의 0번째 순서에 있는 것의 카운트가 올라간다. 
							 //b를 넣으면 98-97=1이므로 배열의 1번째 순서에 있는 것의 카운트가 올라간다.
		}
		for (int i=0;i<count.length ;i++ )
		{
			System.out.println(alphabet[i]+": "+count[i]);
								//배열을 만들어 넣지않고 (char)(i+'a') 'a'=97로도 가능
		}
	}
}
