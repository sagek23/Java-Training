package homework2;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoTest2 {

	public static void main(String[] args) {
		
		ArrayList<Set> list = new ArrayList<Set>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ζ� ������ �Է��ϼ���.(���� 1000) ==>");
		String price = sc.next(); //3000
		price = price.substring(0, price.length()-3);
		int n = Integer.parseInt(price);
		
		for(int i=0; i<n; i++) {
			Random r = new Random();
			TreeSet s = new TreeSet();
			for(int j =0; s.size()<6 ; j++) {
				int k = r.nextInt(45)+1;
				s.add(k);
			}			
			list.add(s);
		}
		for(Set lotto  :list)
			System.out.println(lotto);
		}	
	
	// �ݺ��� ���Ŀ� �ζ� ��ȣ�� �����ǵ���
	// ���α׷��� ������ ���ϴ�.
	
	
	
	
}