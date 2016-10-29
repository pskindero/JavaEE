package com.pskindero.javaee.learning.jpadaoexample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pskindero.javaee.learning.jpadaoexample.entities.Author;
import com.pskindero.javaee.learning.jpadaoexample.entities.AuthorDaoJpaImpl;
import com.pskindero.javaee.learning.jpadaoexample.jpadaomodel.GenericDao;

public class EntityManagerProvider {
	
	private static EntityManagerProvider instance;
	private EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

	private EntityManagerProvider() {
	}
	
	public static EntityManagerProvider getInstance() {
		if (instance == null) {
			instance = new EntityManagerProvider();
		}
		return instance;
	}
	
	public EntityManager getEntityManager() {
		return sessionFactory.createEntityManager();
	}

}
