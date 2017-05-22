package com.pskindero.javaee.javaeetech.jpa.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<E, K extends Serializable> {

	E findById(K id);
	
	List<E> findAll();
	
	E save(E entity);
	
	void delete(E entity);
	
	E update(E entity);
	
	
}
