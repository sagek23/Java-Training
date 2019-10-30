package exam;

public class SearchArray {
	public static void search(int []arr, int value) throws NotFoundException {
		int i=0;
		for(i =0; i<arr.length; i++) {
			if(arr[i] == value) {
				System.out.println("찾는 값이 있습니다.");
				break;
			}
		}
		if (i >= (arr.length)) {
			throw new NotFoundException("찾는 값이 없습니다.");
		}
	}
}
