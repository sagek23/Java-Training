import java.util.*;
class  HW3
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int []count = new int[26];
		String []alphabet = {"a","b","c","d","e","f","g","h","i","j"
			,"k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		System.out.println("���ڿ��� �Է��Ͻÿ�");
		String buffer = sc.nextLine();
		buffer = buffer.toLowerCase(); //String�� ��밡��
		for (int i=0;i<buffer.length() ;i++ )
		{
			char ch = buffer.charAt(i); //'a' = 97 'b' = 98
			//Character.toLowerCase(ch)���ϸ� String�� �ƴϾ toLower(Upper)Case�� ����
			if (ch == ' ')
				continue;
			count[ch-'a']++;  //a�� ������ 97-97 = 0���� �迭�� 0��° ������ �ִ� ���� ī��Ʈ�� �ö󰣴�. 
							 //b�� ������ 98-97=1�̹Ƿ� �迭�� 1��° ������ �ִ� ���� ī��Ʈ�� �ö󰣴�.
		}
		for (int i=0;i<count.length ;i++ )
		{
			System.out.println(alphabet[i]+": "+count[i]);
								//�迭�� ����� �����ʰ� (char)(i+'a') 'a'=97�ε� ����
		}
	}
}
