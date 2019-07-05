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

	@Override
	public void showResults(Request request) {
		
		this.request = request ; 
		System.out.println("StoryDeleteView\n");
		
		if (request!=null) {
			
			//System.out.println("Cancellazione andata a buon fine.\n");
			//MainDispatcher.getInstance().callView("Story", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id dell'utente da cancellare
	 */
	@Override
	public void showOptions() {
		
			System.out.print("Inserisci id della storia da cancellare:");
			this.id_story = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con l'id dell'utente da cancellare
	 */
	@Override
	public void submit() {
		request.put("id_storia", id_story);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Story", "doControl", request);
	}


}
