package exam1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HashMap<String, Integer> map = new HashMap<String, Integer>();
		//LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		map.put("������", 23);
		map.put("������", 24);
		map.put("õ����", 29);
		map.put("�载��", 29);
		map.put("���ظ�", 25);
		map.put("�����", 31);
		
		System.out.println(map);
	}

}
