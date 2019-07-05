package it.contrader.view.libro;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class LibroUpdateView extends AbstractView {
	private Request request;

	private int id_Libro;
	private String nome_Libro;
	private final String mode = "UPDATE";

	public LibroUpdateView() {
	}

	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Libro", null);
		}
	}

	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del Libro:");
			id_Libro = Integer.parseInt(getInput());
			System.out.println("Inserisci il Nome del Libro:");
			nome_Libro = getInput();
			
		} catch (Exception e) {

		}
	}


	@Override
	public void submit() {
		request.put("id_Libro", id_Libro);
		request.put("Nome_Libr", nome_Libro);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Libro", "doControl", request);
	}

}
