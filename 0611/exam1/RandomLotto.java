package exam1;

import java.util.HashSet;
import java.util.Random;

public class RandomLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����(������ ��, ������ ��, ����̱�)�߻�
		//1~45������ ���ϳ��� �߻��Ͽ� ���
		HashSet set = new HashSet();
		Random r = new Random();
		for (;;)
		{
			int n = r.nextInt(45)+1;//���� ���� ������ ���� �߻�. 45�� ������ 0~44������ ���� �߻� 
			set.add(n);
			if (set.size()==6)
				break;
		}
		System.out.println(set);
	}

}
