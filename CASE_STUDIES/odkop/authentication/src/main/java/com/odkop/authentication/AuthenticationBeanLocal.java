package com.odkop.authentication;

import javax.ejb.Local;

@Local
public interface AuthenticationBeanLocal {

	boolean verifyCreditentials(String login, String password);
	
	String generateToken();
}
