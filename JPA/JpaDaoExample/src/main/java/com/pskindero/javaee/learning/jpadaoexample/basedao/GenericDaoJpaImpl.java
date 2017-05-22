package com.pskindero.javaee.learning.jpadaoexample.jpadaomodel;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import com.pskindero.javaee.learning.jpadaoexample.EntityManagerProvider;

public class GenericDaoJpaImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	protected Class<T> entityClass;

	protected EntityManager entityManager;
	
	public GenericDaoJpaImpl() {
		entityManager = EntityManagerProvider.getInstance().getEntityManager();
	}

	public T create(T entity) {
		startTransaction();
		this.entityManager.persist(entity);
		commitTransaction();
		return entity;
	}

	public T update(T entity) {
		startTransaction();
		this.entityManager.merge(entity);
		commitTransaction();
		return entity;
	}

	public void delete(T entity) {
		startTransaction();
		this.entityManager.remove(entity);
		commitTransaction();
	}

	public T read(PK id) {
		startTransaction();
		T result =this.entityManager.find(this.entityClass, id);
		commitTransaction();
		return result;
	}

	protected void startTransaction() {
		entityManager.getTransaction().begin();
	}
	
	protected void commitTransaction() {
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
