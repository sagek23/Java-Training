package exam1;

import java.util.ArrayList;

//������ ���̸� ArrayList�� ��� ��ճ��� ���
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
		for (int i:al) //auto unboxing���ֱ� ������ int�� �� �� �ִ�.
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
