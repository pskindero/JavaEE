package com.pskindero.javaee.javaeetech.jpa.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K>{
	
	private static final Logger LOGGER = LogManager.getLogger(GenericDaoImpl.class);

	private Class<E> entityClass;
	
	@PersistenceContext(unitName = "employee_db")
	protected EntityManager entityManager ;//= Persistence.createEntityManagerFactory("employee_db").createEntityManager();
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
	    entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	@PostConstruct
	public void postConstruct() {
		LOGGER.info("object created with hashCode={}", hashCode());
	}
	
	public E findById(K key) {
		return entityManager.find(entityClass, key);
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findAll() {
        Query query = entityManager.createQuery("from " + entityClass.getName());
		return query.getResultList();
	}
	
	public E save(E entity) {
		entityManager.persist(entity);
		return entity;
	}
	
	public void delete(E entity) {
		entityManager.merge(entity);
		entityManager.remove(entity);
	}
	
	public E update(E entity) {
		return entityManager.merge(entity);
	}
	
}
