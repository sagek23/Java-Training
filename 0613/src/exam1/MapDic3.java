package exam1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MapDic3 {

	public static void menu()
	{
		System.out.println("1.검색 2.추가 3.삭제 0.종료");
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
		map.put("tigre", "호랑이");
	

		Set keys = map.keySet();
		Iterator iter = keys.iterator();//set자체로 반복문 수행불가
												//set의 데이터를 하나씩 꺼내오기 위해
												//iterator를 사용. iteratir()메소드가
												//Iterator 객체를 생성. 
	
		while(iter.hasNext())
		{	
			String key = (String)iter.next();//제너릭을 설정하지 않았으므로 캐스팅해야한다.
			String val = (String)map.get(key); //get은 value를 리턴
			System.out.println(key+"="+val);
		}
	}
}
