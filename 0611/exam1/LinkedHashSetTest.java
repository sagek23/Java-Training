package exam1;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet set = new LinkedHashSet(); //�Է¼��� ����
		set.add("����");
		boolean a = set.add("����"); //�ߺ��Ұ�
		set.add(7);
		set.add("����");
		set.add(3);
		
		System.out.println(set);
		System.out.println(a);
	}

}
