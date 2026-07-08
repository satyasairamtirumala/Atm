package Practise;

import java.util.Scanner;

public class User1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		BankAccount add=new BankAccount(110209946502l, "satya", 85000, 102005);
		System.out.println("Enter the pin");
		int pin=sc.nextInt();
		if(pin==(add.getPin())) {
			System.out.println("welcome"+add.getName());
			while (true) {
				System.out.println("please select the option\n1. Deposit\n2. Withdraw\n 3. changepin\n4. checkbalancen\n5. Exit");
				int op=sc.nextInt();
				if(op==1) {
					System.out.print("Enter the amount");
					double amt=sc.nextDouble();
					add.setAmount(amt);
				}
				else if(op==2) {
					System.out.print("Enter the amount");
					double amt=sc.nextDouble();
					if(add.getBal()>amt) {
						add.setAmount(amt);
					}
					else {
						System.out.println("No sufficient amount");
					}
				}
				else if(op==3) {
					System.out.println("Enter the old pin");
					int opin=sc.nextInt();
					if(add.getPin()==opin) {
						System.out.println("Enter the new pin");
						int npin=sc.nextInt();
						if(count(npin)) {
							add.setPin(npin);
							System.out.println("Pin changed Sucessfully");
						}
					}
				}
				else if(op==4) {
					System.out.println(add.getBalance());
				}
				else if(op==5) {
					System.out.println("Thank you Visit again");
					break;
				}
				else {
					System.out.println("Invalid input");
				}
			}
		}

	}
public static boolean count(int n) {
	int count=0;
	while(n!=0) {
		count++;
		n=n/10;
	}
	return count==6;
}
}
final class BankAccount{
	private long acno;
	private String name;
	private double balance;
	private int pin;
	public BankAccount(long acno, String name, double balance, int pin) {
		super();
		this.acno = acno;
		this.name = name;
		this.balance = balance;
		this.pin = pin;
	}
	public int  getPin() {
		return pin;
	}
	public String getName() {
		return name;
	}
	public void setAmount(double amt) {
		balance=amt;
	}
	public double getBal() {
		return this.balance;
	}
	public  void setPin(int n) {
		this.pin=n;
	}
	public double getBalance() {
		return this.balance;
	}
}
