package model.post;

import java.sql.Date;

public class PostVO {
	
	private int pnum;
	private String title;
	private String content;
	private Date pdate;
	private String userID;
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	@Override
	public String toString() {
		return "PostVO [pnum=" + pnum + ", title=" + title + ", content=" + content + ", pdate=" + pdate + ", userID="
				+ userID + "]";
	}
	
	
	
}
