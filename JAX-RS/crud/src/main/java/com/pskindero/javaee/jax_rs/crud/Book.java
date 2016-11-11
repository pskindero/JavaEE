package com.pskindero.javaee.jax_rs.crud;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"id", "title", "author", "prize"})
public class Book {

	private static long idGen = 1;
	
	private long id;
	private String title;
	private String author;
	private double prize;
	
	public Book() {
		super();
	}
	
	public Book(String title, String author, double prize) {
		super();
		this.id = idGen;
		this.title = title;
		this.author = author;
		this.prize = prize;
		idGen++;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", author=");
		builder.append(author);
		builder.append(", prize=");
		builder.append(prize);
		builder.append("]");
		return builder.toString();
	}
}
