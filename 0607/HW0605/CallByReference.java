package HW0607;
/*
 * �޼ҵ� ȣ��ÿ� �Ű������� �����ڷ���(�迭,Ŭ������(��ü)�� ����)�� ���� �Ǵ� ������ 
 * �Ű������� ���޵� ���� �޼ҵ� �ȿ��� ����Ǹ� �޼ҵ� ȣ���� �ʿ��� ����� ���� ���� �ȴ�.
 * */
public class CallByReference {
	int value;

	CallByReference(int value) {

	this.value = value;

	}



	public static void cValue(CallByReference x, CallByReference y) {

	int temp = x.value;

	x.value = y.value;

	y.value = temp;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallByReference a = new CallByReference(10);

		CallByReference b = new CallByReference(20);



		System.out.println("cValue() ȣ�� �� : a = " + a.value + ", b = " + b.value);



		cValue(a, b);



		System.out.println("cValue() ȣ�� �� : a = " + a.value + ", b = " + b.value);
	}

}
