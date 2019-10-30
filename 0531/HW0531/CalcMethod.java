

public class CalcMethod {
	public static void main(String[]args) {
	
		int [] arr = { 5, 3, 2, 4, 1};
		
		getTotal(arr);
		getAverage(arr);
		getMaximum(arr);
		getMinimum(arr);
		
		double a = getTotal2(arr);
		

	

		System.out.println("배열의 요소의 총합은 " + a + "입니다");
	
		double b = getAverage2(arr);
		System.out.println("배열 요소들의 평균 값은 " + b + "입니다");
		
		int c =getMaximum2(arr);
		System.out.println("배열의 요소중 가장큰 값은 " + c + "입니다");
		
		int d = getMinimum2(arr);
		System.out.println("배열의 요소중 가장 작은 값은 " + d + "입니다");
		
		
		
	}
	
	public static void getTotal(int[]a) {
		int sum = 0;
		
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		};
		System.out.println("배열의 요소의 총합은 " + sum + "입니다");
		
	}
	public static void getAverage(int[]a) {
		int sum = 0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		};
		int avg = sum/a.length;
		System.out.println("배열 요소들의 평균 값은 " + avg + "입니다");
		
	}
	public static void getMaximum(int[]a) {
		int max = a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		System.out.println("배열의 요소중 가장큰 값은 " + max + "입니다");
	}
	public static void getMinimum(int[]a) {
		int min = a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i] < min) {
				min = a[i];
			}
		}
		System.out.println("배열의 요소중 가장 작은 값은 " + min + "입니다");
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
