package exam1;

import java.util.ArrayList;

public class ArrayListTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<Integer>();
		/*collection framework는 객체만 상대.
		 * 기본자료형은 상대하지 않는다.
		 * 그러므로 ArrayList<int>는 불가
		 */
		al.add(new Integer(3));
		//기본자료형 3을 객체로 포장해서 담아야했음.
		al.add(3);
		//지금은 auto boxing 기능을 제공하므로 객체로 만들 필요가 없다.
		
		Integer a = al.get(0);
		int no = a.intValue();
		
		int n=al.get(0);
		//auto unboxing
		
		/*
		 * 기본자료형 8가지를 객체로 포장해주는 클래스들
		 * Wrapper class라고 한다
		 * byte = Byte
		 * boolean = Boolean
		 * char = Character
		 * short = Short
		 * int = Integer
		 * long = Long
		 * float = Float
		 * double = Double
		 * 
		 * */
	}

}
