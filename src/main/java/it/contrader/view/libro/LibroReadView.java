package it.contrader.view.libro;

import it.contrader.controller.Request;
import it.contrader.dto.LibroDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class LibroReadView extends AbstractView {

	private int id_Libro;
	private Request request;
	private final String mode = "READ";

	public LibroReadView() {
	}

	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			LibroDTO Libro = (LibroDTO) request.get("Libro");
			System.out.println(Libro);
			MainDispatcher.getInstance().callView("Libro", null);
		}
	}


	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del Libro:");
		id_Libro = Integer.parseInt(getInput());
	}

	
	@Override
	public void submit() {
		request.put("ID Libro", id_Libro);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Libro", "doControl", request);
	}

}
