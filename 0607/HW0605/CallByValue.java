package HW0607;
/*
 * 값에의한 호출은 메소드 호출시에 매개변수로 기본자료형이 전달 되는 것으로 매개변수로 전달된 값이 
 * 메소드 안에서 변경 되더라도 메소드 호출한 쪽에서 변경된 값이 적용되지 않는다.
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

		System.out.println("호출 전 : a = " + a + ", b = " + b);
		cValue(a, b);
		System.out.println("호출 후 : a = " + a + ", b = " + b);
	}

}
