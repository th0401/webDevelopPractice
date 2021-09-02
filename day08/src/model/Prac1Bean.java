package model;

import java.util.Arrays;

public class Prac1Bean {
	
	private String[] item = {"아메리카노 : 2000원","카페라떼 : 3000원","딸기라떼 : 5000원"};
	private int[] price = {2000,3000,5000};
	public String[] getItem() {
		return item;
	}
	public int[] getPrice() {
		return price;
	}
	
	public int calc(String name,int num) {
		int total = 0; //사용자가 직접 입력하지 않는 데이터 - 초기화
		for(int i = 0; i < this.item.length; i++) {
			if(item[i].equals(name)) {
				total = price[i]*num;
			}
		}
		
		return total;
	}
}
