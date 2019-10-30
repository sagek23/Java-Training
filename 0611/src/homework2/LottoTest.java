package homework2;

import java.util.TreeSet;
import java.util.Random;
import java.util.Scanner;

public class LottoTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("로또 가격을 입력하세요.(개당 1000) ==>");
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
	
	// 반복문 이후에 로또 번호가 유지되도록
	// 프로그램을 수정해 봅니다.
	
	
	
	
}