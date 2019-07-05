package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView {

	String choice;

	@Override
	public void showResults(Request request) {

	}

	@Override
	public void showOptions() {
		System.out.println("Benvenuto su BookMe\n");
		System.out.println("-------------MENU------------\n");

		System.out.println("[E]sci, [C]ategorie, [S]torie");

		choice = this.getInput();

	}

	@Override
	public void submit() {

	


		switch (choice) {

		case "s":
			MainDispatcher.getInstance().callAction("Storie", "doControl", Request.getInstance());
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
