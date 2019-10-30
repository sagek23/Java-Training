package exam1;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet set = new LinkedHashSet(); //입력순서 유지
		set.add("만두");
		boolean a = set.add("만두"); //중복불가
		set.add(7);
		set.add("벨로");
		set.add(3);
		
		System.out.println(set);
		System.out.println(a);
	}

}
