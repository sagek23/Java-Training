package exam1;

import java.util.ArrayList;
import java.util.HashMap;

/*� ����� �̸�, ����, �ּҸ� List�� �����ϰ� ���
 *� ����� �̸�, ����, �ּҸ� Map�� �����ϰ� ���*/
public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList mem = new ArrayList();
		mem.add("������");
		mem.add(28);
		mem.add("����� ���α�");
		
		System.out.println(mem.get(2));
		
		HashMap m = new HashMap();
		m.put("�̸�", "������");
		m.put("����", 28);
		m.put("�ּ�", "����� ���α�");
		
		System.out.println(m.get("�ּ�"));
	}

}
