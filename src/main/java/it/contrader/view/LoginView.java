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
	 * chiede in input all'utente uno username e una password usando il metodo getInput() presente in AbstractView
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
			
			MainDispatcher.getInstance().callAction("Registration", "doControl", null);
			
		} else {
			Request request = new Request();
			
			request.put("username", username);
			request.put("password", password);
			
			MainDispatcher.getInstance().callAction("Home", "doControl", request);
		}
		
	}


}
