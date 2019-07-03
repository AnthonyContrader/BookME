package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	Request request;

	@Override
	public void showResults(Request request) {
		System.out.println("Benvenuto su BookMe");

	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("[E]sci, [C]ategorie");
		
		
		
		choice = this.getInput();

	}

	@Override
	public void submit() {

		switch (choice) {
		case "c":
		// TODO: crea menu categorie
				request = new Request();
				MainDispatcher.getInstance().callAction("Category", "doControl", request);
				break;
		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
