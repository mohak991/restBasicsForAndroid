package edu.uic.androidIDS494WS.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.uic.androidIDS494WS.model.Response;
import edu.uic.androidIDS494WS.model.User;
import edu.uic.androidIDS494WS.service.AppService;
import edu.uic.androidIDS494WS.service.ServiceWrapper;

@Path("/register")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegisterUserResource {
	private AppService appService = ServiceWrapper.getInstance();

	@POST
	public Response register(User user) {
		System.out.println("Register Controller");
		Response response = new Response();
		response.setTag("register");
		String message = appService.registerUser(user);
		if (message != null) {
			if(message.equals("Success")) {
				response.setStatus(true);
			} else {
				response.setStatus(false);
				response.setError_message(message);
			}
		} else {
			response.setStatus(false);
			response.setError_message("Unexpected Error !");

		}
		return response;
	}
}
