package com.pskindero.javaee.learning.jpadaoexample.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

//@Entity
//@NamedQuery( name = "Book.readAll", query = "SELECT b FROM Book b")
public class Book {

//	@Id
	private Long id;
	private String title;
	private List<Author> authors;
	
	public Book() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return authors.get(0);
	}
	
	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", authors=");
		builder.append(authors);
		builder.append("]");
		return builder.toString();
	}
}
