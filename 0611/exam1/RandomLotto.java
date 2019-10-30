package exam1;

import java.util.HashSet;
import java.util.Random;

public class RandomLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//난수(무작위 수, 임의의 수, 제비뽑기)발생
		//1~45까지의 수하나를 발생하여 출력
		HashSet set = new HashSet();
		Random r = new Random();
		for (;;)
		{
			int n = r.nextInt(45)+1;//정수 범위 내에서 난수 발생. 45를 넣으면 0~44까지의 수가 발생 
			set.add(n);
			if (set.size()==6)
				break;
		}
		System.out.println(set);
	}

}
