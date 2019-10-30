class BankAccount //main()이 있는 클래스앞에만 public을 붙힌다. 그렇지 않으면 오류가 난다.
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
			System.out.println("잔액 부족");

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
		System.out.println("현재잔고: "+balance);
	}
	public double addInterest()
	{
		return balance*0.75;  //int로 변환하려면 (int)(balance*0.75);
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
		System.out.println("현재잔고: "+a1.getBalance());
		System.out.println("현재잔고: "+a2.getBalance());
		System.out.println("연이율: "+a1.addInterest());
		System.out.println("연이율: "+a2.addInterest());

		a1.printBalance();
		a2.printBalance();

	}
}


/*하나의 파일에 두개 이상의 클래스를 정의할 때 파일명과 같은 이름의 
클래스에만 public을 쓴다. 또 파일명과 같은 이름의 클래스에 main()
메소드를 만든다.
main()은 한개 이상이 올 수 있지만 파일이름과 똑같은 이름의 클래스의 
main()이 동작한다.*/