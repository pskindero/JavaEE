package com.pskindero.javaee.ejb.beans_lifecycle.stateful;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;


@Stateful
public class SomeStatefulBean implements LocalStatefulInterface{

	
	public SomeStatefulBean() {
		System.out.println("Constructor invoked");
	}

	public String getMessage() {
		return "GET MSG";
	}

	//Callback methods
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("PostConstruct invoked");
	}
	
	@PostActivate
	public void postActivate() {
		System.out.println("PostActivate invoked");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("PreDestroy invoked");
	}
	
	@PrePassivate
	public void prePassivate() {
		System.out.println("PrePassivate invoked");
	}
}
