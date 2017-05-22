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

import com.pskindero.javaee.bean.ManagersBeanLocal;
import com.pskindero.javaee.javaeetech.jpa.entity.Manager;

@Path("/managers")
@Produces(MediaType.APPLICATION_JSON)
public class ManagersResource {

	private static final Logger LOGGER = LogManager.getLogger(ManagersResource.class);

	@EJB
	private ManagersBeanLocal bean;
	
	@GET
	public List<Manager> getAllManagers() {
		LOGGER.info("REST method invoked: {}", HttpMethod.GET);
		return bean.getManagers();
	}
	
	@GET
	@Path("/{id}")
	public Manager getManagerById(@PathParam("id") Integer id) {
		LOGGER.info("REST method invoked: {} with id: {}", HttpMethod.GET, id);
		return bean.getManager(id);
	}
}
