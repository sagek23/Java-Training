
import java.util.Scanner;

public class StringDataCreateMethod {

	public static String[] remove(String[] str, int index) {
		String[] tmpStr = new String[str.length - 1];
		int n = 0;
		for (int i = 0; i < str.length; i++) {
			if (i == index) {
				continue;
			}
			tmpStr[n] = str[i];
			n++;
		}
		return tmpStr;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("문장을 입력해주세요 : ");
		String sentence = scan.nextLine();
		//hello java hello korea을 입력한 경우
		String[] sent = sentence.split(" ");
		int[] count = new int[sent.length];
		//[0] [0] [0] [0] 0은 초기값
		// 0   1   2   3
	      
		
		//i:0, 1, 2, 3
		for (int i = 0; i < sent.length; i++) {
			count[i]++;
			//j=1
			for (int j = i + 1; j < sent.length; j++) {
				//"hello" "java"
				if (sent[i].equals(sent[j])) {
					count[i]++;
					sent = remove(sent, j);

					j--; //sent에서 같은 단어가 나온경우 배열 수가 줄기 때문에 감소시킴
				}
			}
		}

		for (int i = 0; i < sent.length; i++) {
			System.out.print(sent[i] + " : ");
			System.out.println(count[i]);
		}

	}

}
