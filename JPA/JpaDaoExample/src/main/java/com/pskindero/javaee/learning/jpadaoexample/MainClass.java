package com.pskindero.javaee.learning.jpadaoexample;

import com.pskindero.javaee.learning.jpadaoexample.entities.AuthorDaoJpaImpl;

public class MainClass {

	public static void main(String[] args) {
		AuthorDaoJpaImpl authorDao = new AuthorDaoJpaImpl();
		System.out.println(authorDao.readAll());
	}

}
