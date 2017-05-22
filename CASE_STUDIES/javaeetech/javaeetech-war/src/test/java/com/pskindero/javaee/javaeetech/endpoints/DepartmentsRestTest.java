package com.pskindero.javaee.javaeetech.endpoints;

import static org.testng.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.testng.annotations.Test;

import com.pskindero.javaee.javaeetech.jpa.entity.Department;
import com.pskindero.javaee.javaeetech.util.BaseRestTest;
import com.pskindero.javaee.javaeetech.util.Endpoints;

public class DepartmentsRestTest extends BaseRestTest{

	@Test
	public void restGET_AllDepartments_ResultOk() {
		execGetAndAssertIfNotOkStatus(Endpoints.GET_ALL_DEPARTMENTS_URL);
	}
	
	@Test
	public void restGET_AllDepartments_Parse() {
		 Response response  = execGetAndReturnResponse(Endpoints.GET_ALL_DEPARTMENTS_URL);
         List<Department> dept = response.readEntity(new GenericType<List<Department>>(){});
         
         assertTrue(dept.size()>0, "No entity returned in response");
	}
	
	@Test
	public void restGET_DupaDepartment_ResultOk() {
		execGetAndAssertIfNotOkStatus(Endpoints.GET_DUPA_DEPARTMENT_URL);
	}
}
