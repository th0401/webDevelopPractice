package day14;

public class Coffee {
	private String coffee;

	public String getCoffee() {
		return coffee;
	}

	public void setCoffee(String coffee) {
		this.coffee = coffee;
	}

	@Override
	public String toString() {
		return coffee;
	}

	public Coffee(String coffee) {
		this.coffee=coffee;
	}
	
}
