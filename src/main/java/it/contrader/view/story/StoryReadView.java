package it.contrader.view.story;

import java.util.List;

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
		
	/*
	 * Se la request � null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo � vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void showResults(Request request) {

			this.request = request ; 
			
			if(request.get("storyRead") != null) {
				
				StoryDTO story = (StoryDTO)request.get("storyRead");
				System.out.println(story.getId_story()+ " "+story.getTrama());
			}
			
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {
		
		if(request.get("storyRead") == null) {
			System.out.println("Inserisci l'ID della storia:");
			id_Storie = Integer.parseInt(getInput());
		}else {
			getInput();
		}
		
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		if(request.remove("storyRead") == null) {
			request.put("id_storia", id_Storie);
			request.put("mode", mode);
		}else {
			request.put("mode","default");
		}
		
		MainDispatcher.getInstance().callAction("Story", "doControl", request);
		
	}

}
