package com.pskindero.javaee.learning.jpadaoexample;

import com.pskindero.javaee.learning.jpadaoexample.entities.AuthorDaoJpaImpl;
import com.pskindero.javaee.learning.jpadaoexample.entities.BookDaoJpaImpl;

public class MainClass {

	public static void main(String[] args) {
		AuthorDaoJpaImpl authorDao = new AuthorDaoJpaImpl();
		System.out.println("Authors in DB: ");
		System.out.println(authorDao.readAll());
		
		BookDaoJpaImpl bookDao = new BookDaoJpaImpl();
		System.out.println("Books in DB: ");
		System.out.println(bookDao.readAll());
	}

}
