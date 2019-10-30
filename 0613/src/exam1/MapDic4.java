package exam1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MapDic4 {

	public static void menu()
	{
		System.out.println("1.검색 2.추가 3.삭제 4.모두출력 0.종료");
		System.out.print("번호를 입력하세요==> ");
	}
	
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
			case 1: System.out.print("단어를 입력하세요==>");
				String sp = sc.next();
				
				String result = map.get(sp);
				if (result == null)
					System.out.println("찾는 단어는 없습니다");
				else
					System.out.println(result); break;
			case 2: 	System.out.print("단어를 입력하세요==>");
				String pa = sc.next();
				System.out.print("뜻==> ");
				String kr = sc.next();
				map.put(pa, kr);
				System.out.println("추가되었습니다");
				break;
			case 3: 
				System.out.print("삭제할 단어==> ");
				String rm = sc.next();
				//String rm1=sc.next();
				map.remove(rm);
				if (map.remove(rm)==null)
					System.out.println(rm+"삭제되었습니다");break;
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
		{System.out.println("끝");}	
	}

}
