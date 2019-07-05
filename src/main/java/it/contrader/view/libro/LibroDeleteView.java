package it.contrader.view.libro;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class LibroDeleteView extends AbstractView {
	private Request request;

	private int id_Libro;
	private final String mode = "DELETE";

	public LibroDeleteView() {
	}


	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Libro", null);
		}
	}


	@Override
	public void showOptions() {
			System.out.println("Inserisci id del Libro:");
			id_Libro = Integer.parseInt(getInput());

	}

	@Override
	public void submit() {
		request.put("id Libro", id_Libro);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Libro", "doControl", request);
	}


}
