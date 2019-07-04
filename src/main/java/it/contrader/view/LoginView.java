package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class LoginView extends AbstractView {

	private String username;
	
	private String password;
	
	private boolean is_new = false;

	public void showResults(Request request) {

	}
	/**
	 * Viene richiesto Accesso o Login e reindirizza l'utente in base alla scelta
	 */
	public void showOptions() {
		
		/*
		 * Verifica se l'utente è registrato o no
		 * */
		String flag;

		System.out.flush();
		System.out.print("[A]ccedi o [R]egistrati: ");
		flag = getInput();
		
		switch(flag.toLowerCase()) {
		case "a":
			System.out.println("\n----- .:LOGIN:. ----");
			
			System.out.print(" Nome utente:");
			this.username = getInput();
			
			System.out.print(" Password:");
			this.password = getInput();
			break;
		case "r":
			is_new = true;
			break;
			
			default:
				break;
		}
		
		
		
	}

	/**
	 * Impacchetta una request (metodo request.put("chiave", valore)) e la manda al controller Home tramite il Dispatcher
	 */
	public void submit() {
		
		if(is_new) {
			
			MainDispatcher.getInstance().callView("Registration", null);;
			
		} else {
			
			
			Request.getInstance().put("username", username);
			Request.getInstance().put("password", password);
			
			MainDispatcher.getInstance().callAction("Home", "doControl", Request.getInstance());
		}
		
	}


}
