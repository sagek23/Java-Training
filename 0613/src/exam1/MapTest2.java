package exam1;

import java.util.HashMap;
import java.util.Hashtable;

public class MapTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap map = new HashMap();
		map.put("홍길동", "서울");
		//map.put("이순신", "울산");
		
		System.out.println(map.put("홍길동", "서울"));		
		System.out.println(map.put("홍길동", "포항"));		//수정전의 값을 리턴한 후 수정.
		System.out.println(map.put("이순신", "울산"));		//원래 값이 없으므로 null을 출력하고 값을 입력
		System.out.println(map);
	}

}
