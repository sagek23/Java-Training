package homework2;

import java.util.TreeSet;
import java.util.Random;
import java.util.Scanner;

public class LottoTest {

	public static void main(String[] args) {
		
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
			System.out.println(s);
			}
		}	
	
	// �ݺ��� ���Ŀ� �ζ� ��ȣ�� �����ǵ���
	// ���α׷��� ������ ���ϴ�.
	
	
	
	
}