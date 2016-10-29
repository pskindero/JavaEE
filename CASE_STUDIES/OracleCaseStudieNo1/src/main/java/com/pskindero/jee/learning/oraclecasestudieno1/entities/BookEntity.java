package com.pskindero.jee.learning.oraclecasestudieno1.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class BookEntity implements Serializable{

	private static final long serialVersionUID = -2499998308964346216L;

	@Id
	@NotNull
	@GeneratedValue
	private Integer id;
	
	@NotNull
	private String title;
	private String authorName;
	private String authorLastName;
	private Double prize;
	private String description;
	private Integer inventory;
	
	public BookEntity(Integer id, String title, String authorName, String authorLastName, Double prize, String description,
			Integer inventory) {
		this.id = id;
		this.title = title;
		this.authorName = authorName;
		this.authorLastName = authorLastName;
		this.prize = prize;
		this.description = description;
		this.inventory = inventory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public Double getPrize() {
		return prize;
	}

	public void setPrize(Double prize) {
		this.prize = prize;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	
	@Override
	public int hashCode() {
		return this.id != null ? this.id : 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o==null)
			return false;
		if (!(o instanceof BookEntity))
			return false;
		BookEntity other = (BookEntity) o;
		return this.id.equals(other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookEntity [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", authorName=");
		builder.append(authorName);
		builder.append(", authorLastName=");
		builder.append(authorLastName);
		builder.append(", prize=");
		builder.append(prize);
		builder.append(", description=");
		builder.append(description);
		builder.append(", inventory=");
		builder.append(inventory);
		builder.append("]");
		return builder.toString();
	}
}
