package model.bank1;

public class Bank1VO {
	private int b1num;
	private String name;
	private int balance;
	public int getB1num() {
		return b1num;
	}
	public void setB1num(int b1num) {
		this.b1num = b1num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Bank1VO [b1num=" + b1num + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
}
