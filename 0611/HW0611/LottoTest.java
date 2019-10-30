package HW0611;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class LottoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashSet set = new HashSet();
		Random r = new Random();
		int a;
		System.out.print("몇장을 구매하시겠습니까?==> ");
		a = sc.nextInt();
		for (int i=1;i<=a;i++)	
		{	
			for (;;)
			{	
				int n = r.nextInt(45)+1;
				set.add(n);	
				if (set.size()==6)
				{
					System.out.println(set);
					set.removeAll(set);
					break;
				}
			}
		}	
		
	}
}
