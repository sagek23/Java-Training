package exam1;

import java.util.ArrayList;

//팀원의 나이를 ArrayList에 담고 평균나이 출력
public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(29);
		al.add(31);
		al.add(29);
		al.add(25);
		al.add(24);
		al.add(23);
		int sum=0;
		int avg =0;
		for (int i:al) //auto unboxing해주기 때문에 int가 올 수 있다.
		{
			sum+=i;
			avg = sum/al.size();
		}
		System.out.println(avg);
		System.out.println(al);
		al.remove(0);
		System.out.println(al);
		
	}

}
