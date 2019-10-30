package exam1;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class LottoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		HashSet set = new HashSet();
		Random r = new Random();
		for(;;)
		{	int n = r.nextInt(45)+1;
			set.add(n);
			if (set.size()==6)
				break;
		}
		System.out.println(set);
	}

}
