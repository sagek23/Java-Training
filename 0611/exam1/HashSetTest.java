package exam1;

import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet set = new HashSet(); //�迭�� ��������� �پ��� �ڷ��� ���԰���, �ߺ��Ұ�
		
		set.add("�载��");//�ѹ��� �Է� �Ұ�
		set.add(29);
		set.add("����"); //�������Է� ������ �������� ����. �ߺ������� ����
		boolean f = set.add("�载��");
		System.out.println(set);
		System.out.println(f);		
	}

}
