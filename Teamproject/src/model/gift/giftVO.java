package model.gift;

public class giftVO {
	
	private int mnum;
	private String gnum;
	private int gprice;
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getGnum() {
		return gnum;
	}
	public void setGnum(String gnum) {
		this.gnum = gnum;
	}
	public int getGprice() {
		return gprice;
	}
	public void setGprice(int gprice) {
		this.gprice = gprice;
	}
	@Override
	public String toString() {
		return "ÄíÆùÁ¤º¸ [°í°´¹øÈ£=" + mnum + ", ÄíÆù¹øÈ£=" + gnum + ", ÀÜ¾×=" + gprice + "]";
	}
	
    
    

}
