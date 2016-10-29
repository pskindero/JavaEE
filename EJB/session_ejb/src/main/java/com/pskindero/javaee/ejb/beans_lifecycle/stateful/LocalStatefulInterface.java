package com.pskindero.javaee.ejb.beans_lifecycle.stateful;

import javax.ejb.Local;

@Local
public interface LocalStatefulInterface {

	String getMessage();
	
}
