package exam1;

import java.util.HashMap;
import java.util.Hashtable;

public class MapTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap map = new HashMap();
		map.put("ȫ�浿", "����");
		//map.put("�̼���", "���");
		
		System.out.println(map.put("ȫ�浿", "����"));		
		System.out.println(map.put("ȫ�浿", "����"));		//�������� ���� ������ �� ����.
		System.out.println(map.put("�̼���", "���"));		//���� ���� �����Ƿ� null�� ����ϰ� ���� �Է�
		System.out.println(map);
	}

}
