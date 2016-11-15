package com.pskindero.javaee.bean_validation.custom_annotation.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class Person {

	private String name;
	
	private String lastname;
	
	private int age;
	
	private String mail;
	
	public Person(String name, String lastname, int age, String mail) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.mail = mail;
	}

	@NotNull
	@NotBlank(message = "Name cannot be blank")
	@Pattern(regexp = "[a-zA-Z]")
	public String getName() {
		return name;
	}

	@NotNull
	@NotBlank(message = "Name cannot be blank")
	@Pattern(regexp = "[a-zA-Z]")
	public String getLastname() {
		return lastname;
	}

	@NotNull
	@Min(value = 0)
	public int getAge() {
		return age;
	}

	@NotNull
	@EmailAddress
	public String getMail() {
		return mail;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}	
}
