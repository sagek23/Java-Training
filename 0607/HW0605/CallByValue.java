package HW0607;
/*
 * �������� ȣ���� �޼ҵ� ȣ��ÿ� �Ű������� �⺻�ڷ����� ���� �Ǵ� ������ �Ű������� ���޵� ���� 
 * �޼ҵ� �ȿ��� ���� �Ǵ��� �޼ҵ� ȣ���� �ʿ��� ����� ���� ������� �ʴ´�.
 * */
public class CallByValue {
	
	public static void cValue(int x, int y) {

		int temp = x;

		x = y;

		y = temp;

		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;

		int b = 20;

		System.out.println("ȣ�� �� : a = " + a + ", b = " + b);
		cValue(a, b);
		System.out.println("ȣ�� �� : a = " + a + ", b = " + b);
	}

}
