package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;


public class RegistrationView extends AbstractView {

	private String username;
	private String password;
	
	public void showResults(Request request) {
		
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callAction("Registration", "doControl", null);
		}
		
	}
	
	public void showOptions() {
		System.out.flush();
		System.out.println("\n*--- Benvenuto su BookMe, la prima piattaforma di libri intelligenti! ---*\n");
		System.out.print("Inserisci il tuo nome utente: ");
		username = getInput();
		System.out.print("\nInserisci la tua password: ");
		password = getInput();
		
	}
	
	public void submit() {
	
		Request request;
		if(!username.isEmpty() && !password.isEmpty()) {
			request = new Request();
			request.put("username", username);
			request.put("password", password);			
		} else { 
			System.out.println("Input invalido!!\n");
			request = null;
		}
		
		MainDispatcher.getInstance().callAction("Registration", "doControl", request);
	}
}
