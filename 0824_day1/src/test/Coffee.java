package test;

public class Coffee {
	private String coffeeName;
	private int americanoPrice = 2000;
	private int cafelattePrice = 2500;
	private int cnt;
	private int result;
	public Coffee() {
		this.coffeeName="";
		this.result=0;
	}
	
	

	public String getCoffeeName() {
		return coffeeName;
	}



	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}



	public int getAmericanoPrice() {
		return americanoPrice;
	}


	public void setAmericanoPrice(int americanoPrice) {
		this.americanoPrice = americanoPrice;
	}


	public int getCafelattePrice() {
		return cafelattePrice;
	}


	public void setCafelattePrice(int cafelattePrice) {
		this.cafelattePrice = cafelattePrice;
	}


	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}


	public void coffeeOrder() {
		if(this.coffeeName.equals("아메리카노 : 2000원")) {
			this.result = this.americanoPrice * this.cnt;
		}else if(this.coffeeName.equals("카페라떼 : 2500원")) {
			this.result = this.cafelattePrice * this.cnt;
		}
	}
	// 1. 이프에 안걸렸거나 2. cnt가 0일경우
	
	
}
