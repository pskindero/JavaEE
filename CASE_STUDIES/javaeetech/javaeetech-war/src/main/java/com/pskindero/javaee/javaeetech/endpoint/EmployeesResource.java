package com.pskindero.javaee.javaeetech.endpoint;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pskindero.javaee.bean.EmployeesBeanLocal;
import com.pskindero.javaee.javaeetech.jpa.entity.Employee;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeesResource {

	private static final Logger LOGGER = LogManager.getLogger(EmployeesResource.class);
	
	@EJB
	private EmployeesBeanLocal employeeBean;
	
	@GET
	public Response getEmployeeByEmail(@QueryParam("email") String email) {
		if (email == null) {
			LOGGER.info("REST method invoked: {}", HttpMethod.GET);
			return Response
					.ok()
					.entity(employeeBean.getEmployees())
					.build();	
		} else {
			LOGGER.info("REST method invoked: {} with email query param: {}", HttpMethod.GET, email);
			Employee result = employeeBean.getEmployeeByEmail(email);
			if (result != null) {
				return Response
						.ok()
						.entity(result)
						.build();	
			} else {
				return Response
						.status(Status.NO_CONTENT)
						.build();
			}
		}
	}
	
	@GET
	@Path("/{id}")
	public Employee getEmployee(@PathParam("id") int id) {
		LOGGER.info("REST method invoked: {} with id: {}", HttpMethod.GET, id);
		return employeeBean.getEmployee(id);
	}
	
}
