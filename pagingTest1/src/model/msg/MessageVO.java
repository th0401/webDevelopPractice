package model.msg;

import java.sql.Date;

public class MessageVO {

	private int meid;
	private String userID;
	private String msg;
	private int favcount;
	private int replycount;
	private Date udate;
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getMeid() {
		return meid;
	}
	public void setMeid(int meid) {
		this.meid = meid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getFavcount() {
		return favcount;
	}
	public void setFavcount(int favcount) {
		this.favcount = favcount;
	}
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	@Override
	public String toString() {
		return "MessageVO [meid=" + meid + ", userID=" + userID + ", msg=" + msg + ", favcount=" + favcount
				+ ", replycount=" + replycount + ", udate=" + udate + "]";
	}
	
	
	
	
	
	 
}
