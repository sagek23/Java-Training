//�Ǻ���ġ ������ ����, ����ϴ� ���α׷��� �ۼ�
// �Ǻ���ġ �����̶�, ���� �� ���Ҹ� �� �� ���� ���� ���Ұ� �Ǵ� ����

class Weekend03_15{
	public static void main(String []args){

		int a=0, b=1, c=0;
		System.out.print( a + " " + b + " " ); 
		
		while(true) {   //while( c<=2147483647 ) �� �� ������ �����ؼ� ����ص� ���� ����� ���ñ�?
			c = a + b;

			//if(c>Integer.MAX_VALUE)
			if(c<0)
				break;
			System.out.println( c + " " );
			a = b;
			b = c;
			try{
			Thread.sleep(100);
		}catch(Exception e){}

		// if ( c<=2147483647 ) �̷��� ����ϸ�, 0 1 1������ ��� ��. �� �׷���, int ���� �˻��ؼ� �������� ����Ѱǵ�.. �п����� Ȯ������..��������..
			// break;
		
		} // while(true)�� ��� ����ϸ�, -�� ��, int ������ �ʰ��ؼ� �׷���, ���Ƿ� ���������� ��µǰ� �����ϰ� �;��µ�..	
	}
}