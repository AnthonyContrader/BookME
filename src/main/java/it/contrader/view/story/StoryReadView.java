package it.contrader.view.story;

import it.contrader.controller.Request;

import it.contrader.dto.StoryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class StoryReadView extends AbstractView {

	private int id_Storie;
	private Request request;
	private final String mode = "READ";

	public StoryReadView() {
	}

	/**
	 * Se la request � null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo � vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {

		if (request != null) {
			
			this.request = request ; 
			System.out.println("Inserisci id storia : ");
			
			StoryDTO storie = (StoryDTO) request.get("story");
			
			System.out.println(storie.getTrama());
			MainDispatcher.getInstance().callView("Storie", null); 
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {
		/*
		System.out.println("Inserisci l'ID della storia:");
		id_Storie = Integer.parseInt(getInput()); */
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request.put("id", id_Storie);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Story", "doControl", request);
	}

}
