package it.contrader.view.story;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class StoryUpdateView extends AbstractView {
	private Request request;

	private int id_storie;
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
		
		this.request = request ; 
		
		if (request!=null) {
			//System.out.println("Modifica andata a buon fine.\n");
			//MainDispatcher.getInstance().callView("Storie", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		
		System.out.print("Inserisci id storia da modificare:");
		id_storie = Integer.parseInt(getInput());
		System.out.print("Inserisci nuova trama:");
		trama = getInput();
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		
		request.put("id_storia", id_storie);
		request.put("trama", trama);
		request.put("mode", mode);
		
		MainDispatcher.getInstance().callAction("Story", "doControl", request);
	}

}
