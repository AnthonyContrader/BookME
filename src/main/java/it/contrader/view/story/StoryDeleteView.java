package it.contrader.view.story;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class StoryDeleteView extends AbstractView {
	private Request request;

	private int id_story;
	private final String mode = "DELETE";

	public StoryDeleteView() {
	}

	/**
	 * Se la request non � nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Story", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id dell'utente da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id della storia:");
			id_story = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con l'id dell'utente da cancellare
	 */
	@Override
	public void submit() {
		request.put("id", id_story);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Story", "doControl", request);
	}


}
