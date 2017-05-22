package com.pskindero.javaee.bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pskindero.javaee.javaeetech.jpa.dao.impl.ManagersDaoImpl;
import com.pskindero.javaee.javaeetech.jpa.entity.Employee;
import com.pskindero.javaee.javaeetech.jpa.entity.Manager;

/**
 * Session Bean implementation class ManagersBean
 */
@Stateless
@LocalBean
public class ManagersBean implements ManagersBeanLocal {

private static final Logger LOGGER = LogManager.getLogger(ManagersBean.class);
	
	@Inject
	private ManagersDaoImpl dao;
	
    public ManagersBean() {
    }
	
	public List<Manager> getManagers() {
		LOGGER.info("Get all Managers");
		List<Manager> result = dao.findAll();
		LOGGER.info("Get all Managers result: {}", result);
		return result;
	}
	
	public Manager getManager(Integer id) {
		LOGGER.info("Get Manager by id: {}", id);
		Manager result = dao.findById(id);
		LOGGER.info("Get Manager by id: {}, result: {}", id, result);
		return result;
	}

}
