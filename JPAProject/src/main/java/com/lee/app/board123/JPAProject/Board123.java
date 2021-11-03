package com.lee.app.board123.JPAProject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



/**
 * Entity implementation class for Entity: Board123
 *
 */
@Entity
@Table(name="BOARD123")
public class Board123 {

	@Id
	@GeneratedValue
	private int id; // 식별자 필드==PK
	private String title;
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date wdate=new Date();
	@Transient
	private String condition;
	@Transient
	private String keyword;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}	
	
	@Override
	public String toString() {
		return "Board123 [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content + ", wdate="
				+ wdate + ", condition=" + condition + ", keyword=" + keyword + "]";
	}

	public Board123() {
		
	}
   
}
