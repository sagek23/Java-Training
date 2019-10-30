package HW0607;
/*
 * 메소드 호출시에 매개변수로 참조자료형(배열,클래스형(객체)의 변수)이 전달 되는 것으로 
 * 매개변수로 전달된 값이 메소드 안에서 변경되면 메소드 호출한 쪽에서 변경된 값이 적용 된다.
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



		System.out.println("cValue() 호출 전 : a = " + a.value + ", b = " + b.value);



		cValue(a, b);



		System.out.println("cValue() 호출 전 : a = " + a.value + ", b = " + b.value);
	}

}
