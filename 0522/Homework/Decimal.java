class  Decimal
{
	public static void main(String[] args) 
	{
		double a =56.3534534;
		//a = new Double(String.format("%.2f",a)); //�ڷ��� ����
		//�ݿø��Ͽ� �Ҽ� ��°�ڸ����� ���.
		//�ݿø������ʰ� �Ҽ� ��°¥������ ����Ϸ���?
		System.out.println(Math.floor(a*100)/100.0);
		//String b = String.format("%.2f",a) //2f->�Ҽ��� ��°�ڸ����� ǥ��
		System.out.println(a);
	}
}
