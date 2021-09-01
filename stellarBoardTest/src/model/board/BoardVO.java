package model.board;

import java.sql.Date;

public class BoardVO {
	int bnum;
	String title;
	String content;
	String writer;
	Date bdate;
	int bmem;
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	
	public int getBmem() {
		return bmem;
	}
	public void setBmem(int bmem) {
		this.bmem = bmem;
	}
	@Override
	public String toString() {
		return "BoardVO [bnum=" + bnum + ", title=" + title + ", content=" + content + ", writer=" + writer + ", bdate="
				+ bdate + ", bmem=" + bmem + "]";
	}
	
	
}
