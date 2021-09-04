package model.menu;

public class menuVO {
	private int snum;
	private int menunum;
	private String menuname;
	private int price;
	private int menucnt;
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public int getMenunum() {
		return menunum;
	}
	public void setMenunum(int menunum) {
		this.menunum = menunum;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMenucnt() {
		return menucnt;
	}
	public void setMenucnt(int menucnt) {
		this.menucnt = menucnt;
	}
	@Override
	public String toString() {
		return "menuVO [snum=" + snum + ", menunum=" + menunum + ", menuname=" + menuname + ", price=" + price
				+ ", menucnt=" + menucnt + "]";
	}
	
	

}
