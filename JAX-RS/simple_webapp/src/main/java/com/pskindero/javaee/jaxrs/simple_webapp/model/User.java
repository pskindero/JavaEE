package com.pskindero.javaee.jaxrs.simple_webapp.model;

public class User {

	private static long idGen = 1;
	private long id;
	private String login;
	private String name;
	private String surname;
	private String mail;
	
	public User(String login, String name, String surname, String mail) {
		super();
		this.id = idGen;
		idGen++;
		this.login = login;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
	}

	public long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getMail() {
		return mail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", login=");
		builder.append(login);
		builder.append(", name=");
		builder.append(name);
		builder.append(", surname=");
		builder.append(surname);
		builder.append(", mail=");
		builder.append(mail);
		builder.append("]");
		return builder.toString();
	}
}
