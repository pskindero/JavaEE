package com.odkop.authentication;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.odkop.authentication.model.UserCreditentials;

@Path("/authentication")
public class AuthenticationEndpoint {

	private static final Logger LOGGER = LogManager.getLogger(AuthenticationEndpoint.class);
	
	@Inject
	private AuthenticationBean autheanticationBean;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserCreditentials getMethod() {
		LOGGER.info("GET");
		UserCreditentials uc = new UserCreditentials();
		uc.setLogin("ADMIN");
		uc.setPassword("PASSW");
		return uc;
	}

	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticate(UserCreditentials creditentials) {
		LOGGER.info("Input parameters - creditentials.getLogin(): {}, creditentials.getPassword(): {}", creditentials.getLogin(), creditentials.getPassword());
		if (this.autheanticationBean.verifyCreditentials(creditentials.getLogin(), creditentials.getPassword())) {
			LOGGER.info("Authentication PASSED for creditentials.getLogin(): {}", creditentials.getLogin());
			String token = this.autheanticationBean.generateToken();
			LOGGER.debug("Generated token: {} for creditentials.getLogin() {}", token, creditentials.getLogin());
			return Response.ok(token).build();
		} else {
			LOGGER.info("Authentication FAILED for creditentials.getLogin(): {}", creditentials.getLogin());
			return Response.status(Status.UNAUTHORIZED).build();
		}
	}

}
