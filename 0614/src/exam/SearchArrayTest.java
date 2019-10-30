package exam;

public class SearchArrayTest {

	public static void main(String[] args) {
		
		try {
			int arr[] = {32, 45 ,27, 12, 23, 8};
			
			SearchArray.search(arr, 100);
			SearchArray.search(arr, 27);
			
		}catch(NotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
