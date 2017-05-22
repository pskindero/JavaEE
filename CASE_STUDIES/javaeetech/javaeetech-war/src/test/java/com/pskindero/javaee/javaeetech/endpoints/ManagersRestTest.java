package com.pskindero.javaee.javaeetech.endpoints;

import static org.testng.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.testng.annotations.Test;

import com.pskindero.javaee.javaeetech.jpa.entity.Manager;
import com.pskindero.javaee.javaeetech.util.BaseRestTest;
import com.pskindero.javaee.javaeetech.util.Endpoints;

public class ManagersRestTest extends BaseRestTest{

	@Test
	public void restGET_AllManagers_ResultOk() {
		execGetAndAssertIfNotOkStatus(Endpoints.GET_ALL_MANAGERS_URL);
	}
	
	@Test
	public void restGET_AllManagers_Parse() {
		 Response response  = execGetAndReturnResponse(Endpoints.GET_ALL_MANAGERS_URL);
         List<Manager> dept = response.readEntity(new GenericType<List<Manager>>(){});
         
         assertTrue(dept.size()>0, "No entity returned in response");
	}
	
	@Test
	public void restGET_FirstManager_ResultOk() {
		execGetAndAssertIfNotOkStatus(Endpoints.GET_SECOND_MANAGER_URL);
	}
}
