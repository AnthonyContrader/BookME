package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;

	Request request ;


	@Override
	public void showResults(Request request) {
		this.request = request;
	}

	@Override
	public void showOptions() {
		System.out.println("Benvenuto su BookMe\n");
		System.out.println("-------------MENU------------\n");
		
		System.out.println("[E]sci, [C]ategorie, [I]nserisci storia");

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
			break;
		case "c":
		// TODO: crea menu categorie
				MainDispatcher.getInstance().callAction("Category", "doControl", request);
				break;
		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", request);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", request);
		}
	}

}
