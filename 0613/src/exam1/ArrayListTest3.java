package exam1;

import java.util.LinkedList;

public class ArrayListTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> al = new LinkedList<Integer>();
		al.add(29);
		al.add(29);
		al.add(31);
		al.add(25);
		al.add(24);
		al.add(23);
		
		int sum = 0;
		int avg = 0;
		for (int i:al)
			sum+=i;
			avg=sum/al.size();
		System.out.println(avg);
		System.out.println(al);
		al.remove(0);
		System.out.println(al);
	}

}
