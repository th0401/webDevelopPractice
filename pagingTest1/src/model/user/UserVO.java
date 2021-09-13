package model.user;

import java.sql.Date;

public class UserVO {

	private String userID;
	private String name;
	private String userPW;
	private Date udate;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	@Override
	public String toString() {
		return "UserVO [userID=" + userID + ", name=" + name + ", userPW=" + userPW + ", udate=" + udate + "]";
	}
	
	
}
