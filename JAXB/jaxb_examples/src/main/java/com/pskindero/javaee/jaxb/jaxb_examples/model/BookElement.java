package com.pskindero.javaee.jaxb.jaxb_examples.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

//
//@XmlRootElement
//@XmlAccessorType (XmlAccessType.FIELD)
//@XmlType(propOrder = {"id", "book", "prize"})
public class BookElement {

	private static long idGen = 1L;
	
	private long id;
	private Book book;
	private double prize;
	
	public BookElement() {
		super();
		this.id = idGen;
		idGen++;
	}

	public BookElement(Book book, double prize) {
		this();
		this.book = book;
		this.prize = prize;
	}

	public long getId() {
		return id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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
		builder.append("BookElement [id=");
		builder.append(id);
		builder.append(", book=");
		builder.append(book);
		builder.append(", prize=");
		builder.append(prize);
		builder.append("]");
		return builder.toString();
	}
}
