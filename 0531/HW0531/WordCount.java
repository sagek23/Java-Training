// ��������� ������ �Է¹޾� �ܾ �󵵼��� ���Ͽ� ����ϴ� ���α׷� �ۼ�

import java.util.Scanner;
class WordCount
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ϴ� ������ �Է��ϼ���(��, �������� �մϴ�.)"); 
		String input = sc.nextLine();
		String []word = input.split(" "); 
		int count[] = new int[word.length];

		for ( int i =0; i<word.length ; i++ ) {  	
			for( int j =0; j<word.length; j++){  

				if ( word[i].equals(word[j]) ){

					count[i]++;

				}
			}
		} 

		/*
		[hello][java][hello][korea]			word[]
		[2]		[1]		[2]	  [1]			count[]

		*/
		String result ="";
		for ( int i =0; i<word.length; i++ ) {
			
			int check = result.indexOf( word[i] ); //indexOF �� ���ڰ� �ִ��� ���� ��. ������ -1
			if( 0 > check ){
				result += word[i]; //hello
				result = result + " : " +count[i] + " ";
			}
			
		} System.out.println( result );
	}
}