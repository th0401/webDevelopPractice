package model.member;

public class MemberVO {
	int bmem;
	String userID;
	String userPW;
	String userName;
	public int getBmem() {
		return bmem;
	}
	public void setBmem(int bmem) {
		this.bmem = bmem;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "MemberVO [bmem=" + bmem + ", userID=" + userID + ", userPW=" + userPW + ", userName=" + userName + "]";
	}
	
	
}
