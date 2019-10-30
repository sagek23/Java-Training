package exam1;

import java.util.HashMap;
import java.util.Scanner;

public class MapDic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		Scanner sc =new Scanner(System.in);
		
		map.put("trabajar", "일하다");
		map.put("viajar", "여행하다");
		map.put("comer", "먹다");
		map.put("dormir", "자다");
		map.put("morir", "죽다");
		map.put("beber", "마시다");
		map.put("cantar", "노래하다");
		map.put("estudiar", "공부하다");
		map.put("ir", "가다");
		map.put("volver", "돌아오다");
		map.put("gustar", "좋아하다");
		map.put("entender", "이해하다");
		
		System.out.print("단어를 입력하세요==>");
		String sp = sc.next();
		
		String result = map.get(sp);
		if (result == null)
			System.out.println("찾는 단어는 없습니다");
		else
			System.out.println(result);
		System.out.println("단어를 추가하시겠습니까?(y/n)");
		String a = sc.next();
		if(a.equals("y")||a.equals("Y"))
		{	
			System.out.print("단어==> ");
			String pa = sc.next();
			System.out.print("뜻==> ");
			String kr = sc.next();
			map.put(pa, kr);
			System.out.println("추가되었습니다");
			System.out.print("단어를 입력하세요==>");
			sp = sc.next();
			System.out.println(map.get(sp));
		}
		System.out.println("단어를 삭제하시겠습니까?(y/n)");
		if(a.equals("y")||a.equals("Y"))
		{
			System.out.print("단어==> ");
			String rm = sc.next();
			//String rm1=sc.next();
			map.remove(rm);
			System.out.println("삭제되었습니다");
		}
		
	}

}
