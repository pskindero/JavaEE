package com.odkop.authentication;

import java.util.TreeMap;

import javax.annotation.ManagedBean;

@ManagedBean
public class AuthenticationBean  { //implements AuthenticationBeanLocal {

    private TreeMap<String, String> curr= new TreeMap<String, String>() {
    	{
    		put("ADMIN", "PASS");
    	}
    };

	//@Override
	public boolean verifyCreditentials(String login, String password) {
		if (curr.containsKey(login)) {
			if (curr.get(login).equals(password))
				return true;
		}
		return false;
	}

	//@Override
	public String generateToken() {
		return "123Topen123";
	}
}
