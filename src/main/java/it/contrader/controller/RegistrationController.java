package it.contrader.controller;

import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.UserService;

public class RegistrationController implements Controller{

	private String username, password;
	private final String usertype = "USER"; 
	private UserService userService;
	
	public RegistrationController() {
		userService = new UserService();
	}
	
	public void doControl(Request request) {
		if (request != null) {

			username = request.get("username").toString();
			password = request.get("password").toString();
			
			//costruisce l'oggetto user da inserire
			UserDTO usertoinsert = new UserDTO(username, password, usertype);
			//invoca il service
			userService.insert(usertoinsert);
			Request.getInstance().put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView("Registration", request);
		
					
		}
		else{
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
