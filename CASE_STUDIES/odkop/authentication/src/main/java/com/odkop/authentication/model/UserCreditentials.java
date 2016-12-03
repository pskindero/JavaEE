package com.odkop.authentication.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserCreditentials {

	private String login;
	
	private String password;
	
	public UserCreditentials() {}
	
	public UserCreditentials(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
