

public class CalcMethod2 {
	public static void main(String[]args) {

		String str ="";
		//10 20 30 40 ...100 ..
		//nextLine();
	
		int [] arr = new int[1000]; //����ڿ��� �Է¹޾Ƽ� �� ��� �迭�� �����ְ� ����� ��Ƴ��� �Ѵ�.
		
		getTotal(arr);
		getAverage(arr);
		getMaximum(arr);
		getMinimum(arr);
		
		double a = getTotal2(arr);
		

	

		System.out.println("�迭�� ����� ������ " + a + "�Դϴ�");
	
		double b = getAverage2(arr);
		System.out.println("�迭 ��ҵ��� ��� ���� " + b + "�Դϴ�");
		
		int c =getMaximum2(arr);
		System.out.println("�迭�� ����� ����ū ���� " + c + "�Դϴ�");
		
		int d = getMinimum2(arr);
		System.out.println("�迭�� ����� ���� ���� ���� " + d + "�Դϴ�");
		
		
		
	}
	
	public static void getTotal(int[]a) {
		int sum = 0;
		
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		};
		System.out.println("�迭�� ����� ������ " + sum + "�Դϴ�");
		
	}
	public static void getAverage(int[]a) {
		int sum = 0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		};
		int avg = sum/a.length;
		System.out.println("�迭 ��ҵ��� ��� ���� " + avg + "�Դϴ�");
		
	}
	public static void getMaximum(int[]a) {
		int max = a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		System.out.println("�迭�� ����� ����ū ���� " + max + "�Դϴ�");
	}
	public static void getMinimum(int[]a) {
		int min = a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i] < min) {
				min = a[i];
			}
		}
		System.out.println("�迭�� ����� ���� ���� ���� " + min + "�Դϴ�");
	}
	
	public static int getTotal2(int[]a) {
		int sum = 0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		};
		return sum;
	}
	public static double getAverage2(int[]a) {
		return getTotal2(a)/(double)a.length;
	}
	public static int getMaximum2(int[]a) {
		int max = a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}
	public static int getMinimum2(int[]a) {
		int min = a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}

}
