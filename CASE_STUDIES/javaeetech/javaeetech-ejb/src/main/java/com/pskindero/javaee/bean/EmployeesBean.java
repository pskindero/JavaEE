package com.pskindero.javaee.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pskindero.javaee.javaeetech.jpa.dao.impl.EmployeesDaoImpl;
import com.pskindero.javaee.javaeetech.jpa.entity.Employee;
import com.pskindero.javaee.javaeetech.jpa.entity.Gender;

@Stateless
public class EmployeesBean implements EmployeesBeanLocal {

	private static final Logger LOGGER = LogManager.getLogger(EmployeesBean.class);
	
	@Inject
	private EmployeesDaoImpl dao;
	
    public EmployeesBean() {
    }

	@Override
	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public Employee getEmployee(int id) {
		LOGGER.info("Get Employee by id: {}", id);
		Employee result = dao.findById(id);
		LOGGER.info("Get Employee by id: {} result: {}", id, result);
		return result;
	}
	
	@Override
	public List<Employee> getEmployees() {
		LOGGER.info("Get all Employees");
		List<Employee> result = dao.findAll();
		LOGGER.info("Get all Employees result: {}", result);
		return result;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		LOGGER.info("Get Employee by email: {}", email);
		Employee result = dao.findByEMail(email);
		LOGGER.info("Get Employees by email: {} result: {}", email, result);
		return result;
	}

	@Override
	public List<Employee> getEmployeesByGender(Gender gender) {
		throw new UnsupportedOperationException();
	}
}
