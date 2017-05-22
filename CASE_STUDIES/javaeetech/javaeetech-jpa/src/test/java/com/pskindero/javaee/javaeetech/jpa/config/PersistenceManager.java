package com.pskindero.javaee.javaeetech.jpa.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum PersistenceManager {

	INSTANCE;
	
	private EntityManagerFactory emFactory;
	
	private PersistenceManager() {
		emFactory = Persistence.createEntityManagerFactory("employee_db");
	}
	
	public EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}
}
