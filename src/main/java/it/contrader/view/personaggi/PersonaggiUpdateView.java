package it.contrader.view.personaggi;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class PersonaggiUpdateView extends AbstractView {
	private Request request;

	private int id_Personaggio;
	private String nota;
	private final String mode = "UPDATE";

	public PersonaggiUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Personaggio", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del personaggio:");
			id_Personaggio = Integer.parseInt(getInput());
			System.out.println("Inserisci la nota del personaggio:");
			nota = getInput();
			
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request.put("id_Personaggio", id_Personaggio);
		request.put("nota", nota);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Personaggio", "doControl", request);
	}

}
