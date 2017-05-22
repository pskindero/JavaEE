package com.pskindero.javaee.bean;

import java.util.List;

import javax.ejb.Local;

import com.pskindero.javaee.javaeetech.jpa.entity.Department;

@Local
public interface DepartmentsBeanLocal {

	List<Department> getDepartments();
	
	Department getDepartment(String id);
	
}
