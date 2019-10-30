package exam01;

import java.util.Scanner;

public class SearchArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {32,45,27,12,23,8};
		try {
		SearchArray.search(arr, 27);
		}catch(NotFoundException e)
		{
			System.out.println(e);
		}
	}
}
