package com.pskindero.javaee.jaxb.jaxb_examples.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"name", "lastname", "dateOfBirth"})
public class Person {

	private String name;
	
	private String lastname;
	
	private Date dateOfBirth;
	
	public Person() {}
	
	public Person(String name, String lastname, Date dateOfBirth) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", lastname=");
		builder.append(lastname);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append("]");
		return builder.toString();
	}
}
