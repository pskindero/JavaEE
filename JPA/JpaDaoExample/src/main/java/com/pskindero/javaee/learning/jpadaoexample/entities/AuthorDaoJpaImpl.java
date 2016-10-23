package com.pskindero.javaee.learning.jpadaoexample.entities;

import java.util.List;

import com.pskindero.javaee.learning.jpadaoexample.jpadaomodel.GenericDaoJpaImpl;

public class AuthorDaoJpaImpl extends GenericDaoJpaImpl<Author, Long> implements AuthorDao{

	public AuthorDaoJpaImpl() {
		this.entityClass = Author.class;
	}
	
	public List<Author> readAll() {
		startTransaction();
		List<Author> result = this.entityManager.createNamedQuery("Author.readAll").getResultList();
		commitTransaction();
		return result;
	}
}
