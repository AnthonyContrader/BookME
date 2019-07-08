package it.contrader.view.story;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class StoryInsertView extends AbstractView{
	private Request request;

	private String trama;
	private final String mode = "INSERT";
	private String check;

	public StoryInsertView() {
	}
	
	/**
	 * Se la request non � nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		this.request = request;
		System.out.println("INSERT VIEW");
		if (request!=null) {
			
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
		
		//System.out.println("Sono dentro la StoryInsertView");
			System.out.print("Racconta la tua storia:");
			trama = getInput();
			//System.out.print("mode: "+mode);
			//System.out.print("trama:"+ trama);
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		check = "check";
		request.put("trama", trama);
		request.put("mode", mode);
		request.put("check", check);
		MainDispatcher.getInstance().callAction("Story", "doControl", request);
	}


}
