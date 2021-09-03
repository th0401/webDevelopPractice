package model.login;

public class LoginVO {
	int mnum;
	String id;
	String pw;
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
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	@Override
	public String toString() {
		return "LoginVO [mnum=" + mnum + ", id=" + id + ", pw=" + pw + "]";
	}
	
}
