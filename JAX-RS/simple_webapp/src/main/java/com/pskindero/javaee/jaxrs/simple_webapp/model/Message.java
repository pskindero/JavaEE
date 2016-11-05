package com.pskindero.javaee.jaxrs.simple_webapp.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	//private static long idGen = 1;
	private long id;
	private String author;
	private String message;
	private Date date;
	
	public Message() {
	}
	
	public Message(String author, String message) {
		super();
		id = 0;
		this.author = author;
		this.message = message;
		this.date = new Date();
	}

	public long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [id=");
		builder.append(id);
		builder.append(", author=");
		builder.append(author);
		builder.append(", message=");
		builder.append(message);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}
	
}
