package model.member;

public class memberVO {
	private int mnum;
	private String id;
	private String pw;
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "memberVO [mnum=" + mnum + ", id=" + id + ", pw=" + pw + "]";
	}

}
