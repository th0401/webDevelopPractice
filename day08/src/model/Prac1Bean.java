package model;

import java.util.Arrays;

public class Prac1Bean {
	
	private String[] item = {"�Ƹ޸�ī�� : 2000��","ī��� : 3000��","����� : 5000��"};
	private int[] price = {2000,3000,5000};
	public String[] getItem() {
		return item;
	}
	public int[] getPrice() {
		return price;
	}
	
	public int calc(String name,int num) {
		int total = 0; //����ڰ� ���� �Է����� �ʴ� ������ - �ʱ�ȭ
		for(int i = 0; i < this.item.length; i++) {
			if(item[i].equals(name)) {
				total = price[i]*num;
			}
		}
		
		return total;
	}
}
