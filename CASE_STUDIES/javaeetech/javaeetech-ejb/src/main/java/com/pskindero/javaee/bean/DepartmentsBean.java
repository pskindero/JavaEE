package com.pskindero.javaee.bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pskindero.javaee.javaeetech.jpa.dao.impl.DepartmentsDaoImpl;
import com.pskindero.javaee.javaeetech.jpa.entity.Department;

/**
 * Session Bean implementation class DepartmentsBean
 */
@Stateless
@LocalBean
public class DepartmentsBean implements DepartmentsBeanLocal {

	private static final Logger LOGGER = LogManager.getLogger(DepartmentsBean.class);

	@Inject
	private DepartmentsDaoImpl dao;

	@Override
	public Department getDepartment(String id) {
		LOGGER.info("Get Department by id: {}", id);
		Department result = dao.findById(id);
		LOGGER.info("Get Department by id: {} result: {}", id, result);
		return dao.findById(id);
	}

	@Override
	public List<Department> getDepartments() {
		LOGGER.info("Get all Departments");
		List<Department> result = dao.findAll();
		LOGGER.info("Get all Department result: {}", result);
		return result;
	}

}
