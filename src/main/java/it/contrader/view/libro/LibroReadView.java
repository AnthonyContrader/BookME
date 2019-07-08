package it.contrader.view.libro;

import it.contrader.controller.Request;
import it.contrader.dto.LibroDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class LibroReadView extends AbstractView {

	private Request request;

	public LibroReadView() {
	}

	
	@Override
	public void showResults(Request request) {
		if (request.get("libro") != null) {
			LibroDTO libro = (LibroDTO) request.remove("libro");
			System.out.println(libro.getNome_Libro());
			System.out.println("\nContenuto:\n" + libro.getStoria());
		}
	}


	@Override
	public void showOptions() {
		System.out.println("\n[T]orna al menù");
		getInput();
	}

	
	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("Libro", "doControl", request);
	}

}
