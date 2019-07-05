package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView {

	String choice;
	private Request request ;

	@Override
	public void showResults(Request request) {

	}

	@Override
	public void showOptions() {
		System.out.println("Benvenuto su BookMe\n");
		System.out.println("-------------MENU------------\n");
<<<<<<< HEAD
		
		System.out.println("[E]sci, [C]ategorie, [I]nserisci storia [N]Cani");
=======

		System.out.println("[E]sci, [C]ategorie, [S]torie");
>>>>>>> 625f4e3ea0cbe71d13d2efd648e6ec33fb974e3d

		choice = this.getInput();

	}

	@Override
	public void submit() {

		switch (choice) {

		case "s":
			MainDispatcher.getInstance().callAction("Story", "doControl", Request.getInstance());
			break;
		case "c":
			// TODO: crea menu categorie
			MainDispatcher.getInstance().callAction("Category", "doControl", Request.getInstance());
			break;
		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", Request.getInstance());
			break;
		case "n":
			MainDispatcher.getInstance().callAction("Cani", "doControl", Request.getInstance());
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", Request.getInstance());
		}
	}

}
