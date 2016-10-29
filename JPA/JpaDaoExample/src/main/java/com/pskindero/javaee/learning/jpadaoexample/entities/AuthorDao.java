package com.pskindero.javaee.learning.jpadaoexample.entities;

import java.util.List;

import com.pskindero.javaee.learning.jpadaoexample.jpadaomodel.GenericDao;

public interface AuthorDao extends GenericDao<Author, Long>{

	List<Author> readAll();
}
