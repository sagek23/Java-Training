package exam1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MapDic2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		Scanner sc =new Scanner(System.in);
		
		map.put("trabajar", "���ϴ�");
		map.put("viajar", "�����ϴ�");
		map.put("comer", "�Դ�");
		map.put("dormir", "�ڴ�");
		map.put("morir", "�״�");
		map.put("beber", "���ô�");
		map.put("cantar", "�뷡�ϴ�");
		map.put("estudiar", "�����ϴ�");
		map.put("ir", "����");
		map.put("volver", "���ƿ���");
		map.put("gustar", "�����ϴ�");
		map.put("entender", "�����ϴ�");
		map.put("tigre", "ȣ����");
	

		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();//set��ü�� �ݺ��� ����Ұ�
												//set�� �����͸� �ϳ��� �������� ����
												//iterator�� ���. iteratir()�޼ҵ尡
												//Iterator ��ü�� ����. 
		while(iter.hasNext())
		{	
			String key = iter.next();
			String val = map.get(key); //get�� value�� ����
			System.out.println(key+"="+val);
		}
	}
}
