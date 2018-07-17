package edu.uic.androidIDS494WS.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.uic.androidIDS494WS.model.Response;
import edu.uic.androidIDS494WS.service.AppService;
import edu.uic.androidIDS494WS.service.ServiceWrapper;

@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserAutheticationResource {
	private AppService appService = ServiceWrapper.getInstance();

	@GET
	@Path("/{email}/{password}")
	public Response login(@PathParam("email") String email, @PathParam("password") String password) {
		System.out.println("User Controller");
		Response response = new Response();
		response.setTag("login");
		if (appService.getUser(email, password) != null) {
			response.setStatus(true);
			System.out.println("Setting status to true");
		} else {
			System.out.println("Setting status to false");
			response.setStatus(false);
			response.setError_message("Incorrect Email or Password");
		}
		return response;
	}
}
