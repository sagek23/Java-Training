package exam1;

import java.util.HashMap;
import java.util.Scanner;

public class MapDic {

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
		
		System.out.print("�ܾ �Է��ϼ���==>");
		String sp = sc.next();
		
		String result = map.get(sp);
		if (result == null)
			System.out.println("ã�� �ܾ�� �����ϴ�");
		else
			System.out.println(result);
		System.out.println("�ܾ �߰��Ͻðڽ��ϱ�?(y/n)");
		String a = sc.next();
		if(a.equals("y")||a.equals("Y"))
		{	
			System.out.print("�ܾ�==> ");
			String pa = sc.next();
			System.out.print("��==> ");
			String kr = sc.next();
			map.put(pa, kr);
			System.out.println("�߰��Ǿ����ϴ�");
			System.out.print("�ܾ �Է��ϼ���==>");
			sp = sc.next();
			System.out.println(map.get(sp));
		}
		System.out.println("�ܾ �����Ͻðڽ��ϱ�?(y/n)");
		if(a.equals("y")||a.equals("Y"))
		{
			System.out.print("�ܾ�==> ");
			String rm = sc.next();
			//String rm1=sc.next();
			map.remove(rm);
			System.out.println("�����Ǿ����ϴ�");
		}
		
	}

}
