package it.contrader.view.user;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class StoryUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String trama;
	private final String mode = "UPDATE";

	public StoryUpdateView() {
	}

	/**
	 * Se la request non � nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Story", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id della tua storia:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci la tua storia:");
			trama = getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request.put("id", id);
		request.put("trama", trama);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Story", "doControl", request);
	}

}
