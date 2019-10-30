package exam1;

import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet set = new HashSet(); //배열과 비슷하지만 다양한 자료형 포함가능, 중복불가
		
		set.add("김슬지");//한번에 입력 불가
		set.add(29);
		set.add("마포"); //데이터입력 순서를 유지하지 않음. 중복유무만 관리
		boolean f = set.add("김슬지");
		System.out.println(set);
		System.out.println(f);		
	}

}
