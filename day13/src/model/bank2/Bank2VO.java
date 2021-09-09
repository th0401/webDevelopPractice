package model.bank2;

public class Bank2VO {
	private int b2num;
	private String name;
	private int balance;
	public int getB2num() {
		return b2num;
	}
	public void setB2num(int b2num) {
		this.b2num = b2num;
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
		return "Bank2VO [b2num=" + b2num + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
}
