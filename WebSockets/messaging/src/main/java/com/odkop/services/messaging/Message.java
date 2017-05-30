package com.odkop.services.messaging;

import java.sql.Date;

public class Message {

//	private Date date;
	private String author;
	private String content;
	
	public Message() {}
	
	public Message(String author, String content) {
		//this.date = date;
		this.author = author;
		this.content = content;
	}
	
//	public Date getDate() {
//		return date;
//	}
//	public void setDate(Date date) {
//		this.date = date;
//	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return author + " : " + content;
	}
}
