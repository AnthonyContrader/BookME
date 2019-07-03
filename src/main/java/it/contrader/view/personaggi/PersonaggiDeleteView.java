package it.contrader.view.personaggi;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PersonaggiDeleteView extends AbstractView {
	private Request request;

	private int id_Personaggio;
	private final String mode = "DELETE";

	public PersonaggiDeleteView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Personaggio", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id dell'utente da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id del Personaggio:");
			id_Personaggio = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con l'id dell'utente da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id Personaggio", id_Personaggio);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Personaggio", "doControl", request);
	}


}
