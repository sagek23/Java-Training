class BankAccount //main()�� �ִ� Ŭ�����տ��� public�� ������. �׷��� ������ ������ ����.
{
	double balance;
	void deposit(int amount)
	{
		balance+=amount;
	}
	void withdraw(int amount)
	{
		if (balance>amount)
			balance-=amount;
		else if (balance<amount)
			System.out.println("�ܾ� ����");

	}
	public double getBalance()
	{
		return balance;
	}
	public void setBalance(double b)
	{
		balance = b;
	}
	
	public void printBalance()
	{
		System.out.println("�����ܰ�: "+balance);
	}
	public double addInterest()
	{
		return balance*0.75;  //int�� ��ȯ�Ϸ��� (int)(balance*0.75);
	}

}
class  HW4
{
	public static void main(String[] args) 
	{
		BankAccount a1 = new BankAccount();
		BankAccount a2 = new BankAccount();
		a1.deposit(100);
		a2.deposit(50);
		a1.withdraw(60);
		a2.withdraw(30);
		System.out.println("�����ܰ�: "+a1.getBalance());
		System.out.println("�����ܰ�: "+a2.getBalance());
		System.out.println("������: "+a1.addInterest());
		System.out.println("������: "+a2.addInterest());

		a1.printBalance();
		a2.printBalance();

	}
}


/*�ϳ��� ���Ͽ� �ΰ� �̻��� Ŭ������ ������ �� ���ϸ�� ���� �̸��� 
Ŭ�������� public�� ����. �� ���ϸ�� ���� �̸��� Ŭ������ main()
�޼ҵ带 �����.
main()�� �Ѱ� �̻��� �� �� ������ �����̸��� �Ȱ��� �̸��� Ŭ������ 
main()�� �����Ѵ�.*/