package exam1;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList al = new ArrayList();
		al.add("���");
		al.add("ġ��");
		al.add("ġ��");		
		al.add("���");		
		al.add(2);		
		boolean f = al.add(2);
		System.out.println(f);
		System.out.println(al);
	}

}
