package com.pskindero.javaee.learning.jpadaoexample.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery ( name = "Author.readAll", query = "SELECT a FROM Author a" )
public class Author {

	@Id
	@SequenceGenerator(name = "author_id_seq", sequenceName = "author_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@NotNull
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String lastName;
	
	public Author() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append("]");
		return builder.toString();
	}
}
