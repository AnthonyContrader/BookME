package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView {

	String choice;
	private Request request ;

	@Override
	public void showResults(Request request) {
		if(request!=null) {
			this.request=request;
		}

	}

	@Override
	public void showOptions() {
		request.remove("mode");
		request.remove("choice");
		System.out.println("Benvenuto su BookMe\n");
		System.out.println("-------------MENU------------\n");


		System.out.println("[E]sci, [C]ategorie, [L]ibri");


		choice = this.getInput();

	}

	@Override
	public void submit() {

		switch (choice) {

		//case "s":
			//MainDispatcher.getInstance().callAction("Story", "doControl", Request.getInstance());
			//break;
		case "c":
			// TODO: crea menu categorie
			MainDispatcher.getInstance().callAction("Category", "doControl", Request.getInstance());
			break;
		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", Request.getInstance());
			break;

		case "l":
			MainDispatcher.getInstance().callAction("Libro", "doControl", Request.getInstance());
			break;


		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", Request.getInstance());
		}
	}

}
