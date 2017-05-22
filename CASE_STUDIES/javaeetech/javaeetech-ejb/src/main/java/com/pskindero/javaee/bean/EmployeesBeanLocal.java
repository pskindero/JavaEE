package com.pskindero.javaee.bean;

import java.util.List;

import javax.ejb.Local;

import com.pskindero.javaee.javaeetech.jpa.entity.Employee;
import com.pskindero.javaee.javaeetech.jpa.entity.Gender;

@Local
public interface EmployeesBeanLocal {

	Employee getEmployee(int id);

	List<Employee> getEmployees();
	
	Employee getEmployeeByEmail(String email);
	
	List<Employee> getEmployeesByGender(Gender gender);
}
