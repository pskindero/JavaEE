package com.pskindero.javaee.learning.jpadaoexample.entities;

import java.util.List;

import com.pskindero.javaee.learning.jpadaoexample.jpadaomodel.GenericDao;

public interface BookDao extends GenericDao<Book, Long>{

	List<Book> readAll();
}
