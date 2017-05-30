package com.pskindero.javaee.javaeetech.jpa.model.copy;

import javax.persistence.EntityManager;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pskindero.javaee.javaeetech.jpa.base.JpaUnitTest;
import com.pskindero.javaee.javaeetech.jpa.config.PersistenceManager;
import com.pskindero.javaee.javaeetech.jpa.dao.impl.EmployeesDaoImpl;


public class EmployeeDaoImplTest extends JpaUnitTest{

	private EmployeesDaoImpl dao;
	private EntityManager em;
	
	@BeforeSuite
	public void setup() {
		dao = new EmployeesDaoImpl();
		//em = PersistenceManager.INSTANCE.getEntityManager();
		//inject(dao, "entityManager", em);
	}
	
	
	@Test
	public void readExistingEmployee() {
		
	}
}
