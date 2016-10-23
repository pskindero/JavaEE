package com.pskindero.javaee.learning.jpadaoexample.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = "Book.readAll", query = "SELECT b FROM Book b")
public class Book {

	@Id
	@SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@NotNull
	private Long id;
	
	@NotNull
	private String title;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	public Book() {
	}

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
		return author;
	}

	public void setAuthors(Author author) {
		this.author = author;
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
		builder.append("]");
		return builder.toString();
	}
}
