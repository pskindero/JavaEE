package com.pskindero.javaee.javaeetech.jpa.dao.impl;

import javax.persistence.NoResultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pskindero.javaee.javaeetech.jpa.dao.GenericDaoImpl;
import com.pskindero.javaee.javaeetech.jpa.entity.Employee;

public class EmployeesDaoImpl extends GenericDaoImpl<Employee, Integer>{
	
	private static final Logger LOGGER = LogManager.getLogger(EmployeesDaoImpl.class);

	public Employee findByEMail(String email) {
		try {
			Employee result = (Employee) entityManager
											.createNamedQuery("Employee.findByEMail")
											.setParameter("email", email)
											.getSingleResult();
			LOGGER.info("find by email: {} and result is: {}", email, result);
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}
}
