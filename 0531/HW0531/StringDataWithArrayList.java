

import java.util.ArrayList;
import java.util.Scanner;

public class StringDataWithArrayList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("문장을 입력해주세요 : ");
		String sentence = scan.nextLine();

		String[] sent = sentence.split(" ");
		ArrayList<String> al = new ArrayList<String>();

		for (int i = 0; i < sent.length; i++) {
			al.add(sent[i]);
		}

		int[] count = new int[al.size()]; //개수구하기

		for (int i = 0; i < al.size(); i++) {
			count[i]++;
			for (int j = i + 1; j < al.size(); j++) {

				if (al.get(i).equals(al.get(j))) {

					count[i]++;
					al.remove(j);
					j--;

				}
			}

		}
		for (int i = 0; i < al.size(); i++) {
			System.out.print(al.get(i) + " : ");
			System.out.println(count[i]);
		}

	}

}
