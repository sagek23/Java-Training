package exam1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MapDic3 {

	public static void menu()
	{
		System.out.println("1.�˻� 2.�߰� 3.���� 0.����");
		System.out.print("��ȣ�� �Է��ϼ���==> ");
	}
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
	

		Set keys = map.keySet();
		Iterator iter = keys.iterator();//set��ü�� �ݺ��� ����Ұ�
												//set�� �����͸� �ϳ��� �������� ����
												//iterator�� ���. iteratir()�޼ҵ尡
												//Iterator ��ü�� ����. 
	
		while(iter.hasNext())
		{	
			String key = (String)iter.next();//���ʸ��� �������� �ʾ����Ƿ� ĳ�����ؾ��Ѵ�.
			String val = (String)map.get(key); //get�� value�� ����
			System.out.println(key+"="+val);
		}
	}
}
