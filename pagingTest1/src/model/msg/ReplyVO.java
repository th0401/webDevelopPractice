package model.msg;

import java.sql.Date;

public class ReplyVO {

	private int reid;
	private int meid;
	private String userID;
	private Date udate;
	private String rmsg;
	public int getReid() {
		return reid;
	}
	public void setReid(int reid) {
		this.reid = reid;
	}
	public int getMeid() {
		return meid;
	}
	public void setMeid(int meid) {
		this.meid = meid;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public String getRmsg() {
		return rmsg;
	}
	public void setRmsg(String rmsg) {
		this.rmsg = rmsg;
	}
	@Override
	public String toString() {
		return "ReplyVO [reid=" + reid + ", meid=" + meid + ", userID=" + userID + ", udate=" + udate + ", rmsg=" + rmsg
				+ "]";
	}
	
	
	
	}
