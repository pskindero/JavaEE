package com.pskindero.javaee.javaeetech.endpoint;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pskindero.javaee.bean.DepartmentsBeanLocal;
import com.pskindero.javaee.javaeetech.jpa.entity.Department;

@Path("/departments")
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentsResource {

	private static final Logger LOGGER = LogManager.getLogger(DepartmentsResource.class);

	@EJB
	private DepartmentsBeanLocal bean;
	
	@GET
	public List<Department> getAllDepartments() {
		LOGGER.info("REST method invoked: {}", HttpMethod.GET);
		return bean.getDepartments();
	}
	
	@GET
	@Path("/{id}")
	public Department getDepartmentById(@PathParam("id") String id) {
		LOGGER.info("REST method invoked: {} with id: {}", HttpMethod.GET, id);
		return bean.getDepartment(id);
	}
}
