package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	Request request ;

	@Override
	public void showResults(Request request) {
		//System.out.println("\n-----Purtroppo in questo sample l'utente non pu� fare nulla, ci scusiamo per il disagio.-----");
	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println(" [i] Inserisci una storia ");
		choice = this.getInput();

	}

	@Override
	public void submit() {
		
		request = new Request() ; 
		request.put("choice",choice);
		request.put("mode", "GETCHOICE");

		switch (choice) {

		case "i":
			  MainDispatcher.getInstance().callAction("Story", "doControl", request);
			 //MainDispatcher.getInstance().callView("Story", null);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
