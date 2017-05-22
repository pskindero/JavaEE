package com.pskindero.javaee.javaeetech.endpoints;

import static org.testng.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.testng.annotations.Test;

import com.pskindero.javaee.javaeetech.jpa.entity.Employee;
import com.pskindero.javaee.javaeetech.util.BaseRestTest;
import com.pskindero.javaee.javaeetech.util.Endpoints;

public class EmployeesRestTest extends BaseRestTest{

	@Test
	public void restGET_AllEmployees_ResultOk() {
		execGetAndAssertIfNotOkStatus(Endpoints.GET_ALL_EMPLOYEES_URL);
	}
	
	@Test
	public void restGET_AllEmployees_Parse() {
		 Response response  = execGetAndReturnResponse(Endpoints.GET_ALL_EMPLOYEES_URL);
         List<Employee> emp = response.readEntity(new GenericType<List<Employee>>(){});
         
         assertTrue(emp.size()>0, "No entity returned in response");
	}
	
	@Test
	public void restGET_FirstEmployee_ResultOk() {
		execGetAndAssertIfNotOkStatus(Endpoints.GET_FIRST_EMPLOYEE_URL);
	}
	
}
