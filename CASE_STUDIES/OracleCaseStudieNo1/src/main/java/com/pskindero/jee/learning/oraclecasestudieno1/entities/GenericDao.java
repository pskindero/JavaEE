package com.pskindero.jee.learning.oraclecasestudieno1.entities;

import java.io.Serializable;

public interface GenericDao<T, PK extends Serializable> {

	T create(T entity);
	
	T update(T entity);
	
	void delete(T entity);
	
	T read(PK id);

}
