package exam1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MapDic4 {

	public static void menu()
	{
		System.out.println("1.�˻� 2.�߰� 3.���� 4.������ 0.����");
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
		
		int sel = 0;
		try {
		while(true)
		{
			menu();
			sel = sc.nextInt();
			if (sel==0)
				break;
			switch(sel)
			{
			case 1: System.out.print("�ܾ �Է��ϼ���==>");
				String sp = sc.next();
				
				String result = map.get(sp);
				if (result == null)
					System.out.println("ã�� �ܾ�� �����ϴ�");
				else
					System.out.println(result); break;
			case 2: 	System.out.print("�ܾ �Է��ϼ���==>");
				String pa = sc.next();
				System.out.print("��==> ");
				String kr = sc.next();
				map.put(pa, kr);
				System.out.println("�߰��Ǿ����ϴ�");
				break;
			case 3: 
				System.out.print("������ �ܾ�==> ");
				String rm = sc.next();
				//String rm1=sc.next();
				map.remove(rm);
				if (map.remove(rm)==null)
					System.out.println(rm+"�����Ǿ����ϴ�");break;
			case 4:
				Set<String> s= map.keySet();
				Iterator<String> it = s.iterator();
				while(true)
				{
					String key = it.next();
					String val = map.get(key);
					System.out.println(key+": "+val);
					
				}
			}
		}
	}		
		catch(Exception e)
		{System.out.println("��");}	
	}

}
