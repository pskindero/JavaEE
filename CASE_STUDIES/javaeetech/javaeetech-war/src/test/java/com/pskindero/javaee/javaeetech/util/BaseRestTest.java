package com.pskindero.javaee.javaeetech.util;

import static org.testng.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class BaseRestTest {

	protected Response execGetAndReturnResponse(String url) {
		 Client client = ClientBuilder.newClient();
         WebTarget target = client.target(url);
         Response response = target.request().get();
         return response;
	}
	
	protected void execGetAndAssertIfNotOkStatus(String url) {
		Response response = execGetAndReturnResponse(url);
        assertEquals(response.getStatus(), Status.OK.getStatusCode(), "Invalid response status");
	}
	
}
