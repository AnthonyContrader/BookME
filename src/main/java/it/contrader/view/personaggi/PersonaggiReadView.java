package it.contrader.view.personaggi;

import it.contrader.controller.Request;
import it.contrader.dto.PersonaggiDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class PersonaggiReadView extends AbstractView {

	private int id_Personaggio;
	private Request request;
	private final String mode = "READ";

	public PersonaggiReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			PersonaggiDTO Personaggi = (PersonaggiDTO) request.get("Personaggi");
			System.out.println(Personaggi);
			MainDispatcher.getInstance().callView("Personaggi", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del personaggio:");
		id_Personaggio = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id_Personaggio", id_Personaggio);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Personaggio", "doControl", request);
	}

}
