// ��������� ������ �Է¹޾� �ܾ �󵵼��� ���Ͽ� ����ϴ� ���α׷� �ۼ�

import java.util.Scanner;
class WordCount2
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
		String []result = new String[word.length];
		//[][][][]
		int count2[] = new int[word.length];
		//[][][][]
		int n =1; //�ߺ����� �ʴ� �ܾ ���� �迭. 0��°�� ù���� �ܾ �̹� �������Ƿ� 1���� ����
		result[0] = word[0]; //ù �ܾ�� �˻� ���� �迭�� ����
		count2[0] = count[0];
		for ( int i =1; i<word.length; i++ ) {
			int j=0;
			for (j=0;j<i ;j++ )
			{
				if (word[i].equals(result[j]))
					break; //i:1 j:0�̸� ���� ���� ���� j�� ����, 1<1�� �������� �����Ƿ� if������ �Ѿ. 
			}
			if(j==i) //1==1 �̹Ƿ� ������ ����.
			{	result[n] = word[i];
				count2[n] = count[i];
				n++;
			}

		} 
		for (int i=0; i<n;i++ )
		{
			System.out.println( result[i]+"==>"+count2[i] );
		}
		
		
	}
}