package exam1;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet set = new TreeSet();
		/*
		set.add("쌀국수");
		set.add("햄버거");
		set.add("샌드위치");
		set.add("초밥");
		set.add("반미");  //데이터를 순서대로 정렬
		*/
		set.add("김슬지");
		//set.add(29);	//자료형이 같지않으면 정렬이 불가능하므로 자료형이 같아야함.
		set.add("마포");
		System.out.println(set);
		System.out.println(set.size());//set의 데이터가 몇개있는지 알려주는 기능.
	}

}
