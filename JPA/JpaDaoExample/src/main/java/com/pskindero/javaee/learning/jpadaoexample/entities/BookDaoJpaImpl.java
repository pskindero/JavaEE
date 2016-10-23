package com.pskindero.javaee.learning.jpadaoexample.entities;

import java.util.List;

import com.pskindero.javaee.learning.jpadaoexample.jpadaomodel.GenericDaoJpaImpl;

public class BookDaoJpaImpl extends GenericDaoJpaImpl<Book, Long> implements BookDao{

	public BookDaoJpaImpl() {
		this.entityClass = Book.class;
	}
	
	public List<Book> readAll() {
		startTransaction();
		List<Book> result = this.entityManager.createNamedQuery("Book.readAll").getResultList();
		commitTransaction();
		return result;
	}
}
