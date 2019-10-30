package exam1;

import java.util.ArrayList;
import java.util.HashMap;

/*어떤 사람의 이름, 나이, 주소를 List에 저장하고 출력
 *어떤 사람의 이름, 나이, 주소를 Map에 저장하고 출력*/
public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList mem = new ArrayList();
		mem.add("김지선");
		mem.add(28);
		mem.add("서울시 구로구");
		
		System.out.println(mem.get(2));
		
		HashMap m = new HashMap();
		m.put("이름", "김지선");
		m.put("나이", 28);
		m.put("주소", "서울시 구로구");
		
		System.out.println(m.get("주소"));
	}

}
