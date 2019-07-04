package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;


	@Override
	public void showResults(Request request) {
		
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
		 
		Request.getInstance().put("choice",choice);
		Request.getInstance().put("mode", "GETCHOICE");

		switch (choice) {

		case "i":
			MainDispatcher.getInstance().callAction("Story", "doControl", Request.getInstance());
			break;
		case "c":
		// TODO: crea menu categorie
				MainDispatcher.getInstance().callAction("Category", "doControl", Request.getInstance());
				break;
		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", Request.getInstance());
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", Request.getInstance());
		}
	}

}
