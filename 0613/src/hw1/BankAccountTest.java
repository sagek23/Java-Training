package hw1;

import java.awt.Menu;
import java.util.Scanner;

class BankAccount
{
	double balance=0;
	double dep;
	double wit;
	public double deposit(double dep)
	{
		balance+=dep;
		return balance;
	}
	public double withdraw(double wit)
	{
		balance-=wit;
		return balance;
	}
	public BankAccount(double balance, double dep, double wit) {
		super();
		this.balance = balance;
		this.dep = dep;
		this.wit = wit;
	}
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getDep() {
		return dep;
	}
	public void setDep(double dep) {
		this.dep = dep;
	}
	public double getWit() {
		return wit;
	}
	public void setWit(double wit) {
		this.wit = wit;
	}	
}
class NegativeBalanceException extends Exception
{
	public NegativeBalanceException(String msg)
	{
		super(msg);
	}
}
public class BankAccountTest {

	public static void menu()
	{
	System.out.println("무엇을 하시겠습니까?");
	System.out.println("번호를 골라주세요");
	System.out.println("1.잔액확인 2.입금 3.출금 0.종료");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double deposit=0;
		double withdraw=0;
		
		BankAccount ba = new BankAccount();
		
		int a = 0;
		try {
			while(true)
			{
				menu();
				a = sc.nextInt();
				if(a==0)
					break;
				switch(a)
				{
				case 1: System.out.println("잔액: "+ba.balance);break;
				case 2: System.out.print("입금 금액을 입력하시오==> ");
				deposit = sc.nextDouble();
				System.out.println("입금액: "+deposit);
				System.out.println("잔액: "+ba.deposit(deposit));break;
				case 3: System.out.print("출금 금액을 입력하시오==> ");
				withdraw = sc.nextDouble();
				
				System.out.println("출금액: "+withdraw);
				System.out.println("잔액: "+ba.withdraw(withdraw));break;
				}
				if(ba.balance<ba.wit)
				{
					throw new NegativeBalanceException("잔액이 부족합니다");
				}
			}
		}catch(NegativeBalanceException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
