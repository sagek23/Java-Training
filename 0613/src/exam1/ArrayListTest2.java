package exam1;

import java.util.ArrayList;

public class ArrayListTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<Integer>();
		/*collection framework�� ��ü�� ���.
		 * �⺻�ڷ����� ������� �ʴ´�.
		 * �׷��Ƿ� ArrayList<int>�� �Ұ�
		 */
		al.add(new Integer(3));
		//�⺻�ڷ��� 3�� ��ü�� �����ؼ� ��ƾ�����.
		al.add(3);
		//������ auto boxing ����� �����ϹǷ� ��ü�� ���� �ʿ䰡 ����.
		
		Integer a = al.get(0);
		int no = a.intValue();
		
		int n=al.get(0);
		//auto unboxing
		
		/*
		 * �⺻�ڷ��� 8������ ��ü�� �������ִ� Ŭ������
		 * Wrapper class��� �Ѵ�
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
