package exam;

public class SearchArray {
	public static void search(int []arr, int value) throws NotFoundException {
		int i=0;
		for(i =0; i<arr.length; i++) {
			if(arr[i] == value) {
				System.out.println("ã�� ���� �ֽ��ϴ�.");
				break;
			}
		}
		if (i >= (arr.length)) {
			throw new NotFoundException("ã�� ���� �����ϴ�.");
		}
	}
}
