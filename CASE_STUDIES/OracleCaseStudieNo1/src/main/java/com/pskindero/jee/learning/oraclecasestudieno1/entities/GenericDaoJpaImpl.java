package com.pskindero.jee.learning.oraclecasestudieno1.entities;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDaoJpaImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	protected Class<T> entityClass;

	@PersistenceContext
	private EntityManager entityManager;
	
	public GenericDaoJpaImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	public T create(T entity) {
		this.entityManager.persist(entity);
		return entity;
	}

	public T update(T entity) {
		this.entityManager.merge(entity);
		return entity;
	}

	public void delete(T entity) {
		this.entityManager.remove(entity);
	}

	public T read(PK id) {
		return this.entityManager.find(this.entityClass, id);
	}

}
