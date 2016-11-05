package com.pskindero.javaee.jaxrs.simple_webapp;

import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pskindero.javaee.jaxrs.simple_webapp.model.User;


@Path("user/{username}")
public class SearchUserResource {

	public static Map<String, User> users = new TreeMap<String, User>();
	
	static {
		User u1 = new User("tom", "Tommy", "Li Dzon", "tommy.li@gmail.com");
		User u2 = new User("ian", "Ian", "nai", "ian@nai.com");
		users.put(u1.getLogin(), u1);
		users.put(u2.getLogin(), u2);
	}
	
	public SearchUserResource() {
	}
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@PathParam("username") String userName) {
    	if (users.containsKey(userName))
    		return users.get(userName).toString();
    	else
    		return "User not found in database!";
    }
}
