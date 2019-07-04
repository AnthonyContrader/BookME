package it.contrader.controller;

import java.util.List;

import it.contrader.dto.LibroDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.LibroService;

public class LibroController implements Controller {

	private static String sub_package = "libro.";

	private LibroService libroService;

	public LibroController() {
		libroService = new LibroService();
	}

	@Override
	public void doControl(Request request) {

		// Estrae dalla request mode e choice
		String mode = (String) request.get("mode");

		String choice = (String) request.get("choice");

		int id_Libro;
		String nome_Libro;
		int id_Categoria;

		switch (mode) {

		case "READ":
			id_Libro = Integer.parseInt(request.get("idLibro").toString());
			LibroDTO libroDTO = libroService.read(id_Libro);
			request.put("libro", libroDTO);
			MainDispatcher.getInstance().callView(sub_package + "LibroRead", request);
			break;

		case "INSERT":
			id_Libro = Integer.parseInt(request.get("id_Libro").toString());
			nome_Libro = request.get("NomeLibro").toString();
			id_Categoria = Integer.parseInt(request.get("username").toString());

			// costruisce l'oggetto user da inserire
			LibroDTO librotoinsert = new LibroDTO();
			// invoca il service
			libroService.insert(librotoinsert);
			Request.getInstance().put("mode", "mode");
			// Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "LibroInsert", request);
			break;

		case "DELETE":
			id_Libro = Integer.parseInt(request.get("id_Libro").toString());
			// Qui chiama il service
			libroService.delete(id_Libro);
			Request.getInstance().put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "LibroDelete", request);
			break;

		case "UPDATE":
			id_Libro = Integer.parseInt(request.get("id_Libro").toString());
			id_Categoria = Integer.parseInt(request.get("username").toString());
			nome_Libro = request.get("nome_Libro").toString();
			LibroDTO librotoupdate = new LibroDTO(id_Libro, nome_Libro, id_Categoria);
			librotoupdate.setId_Libro(id_Libro);
			libroService.update(librotoupdate);
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "LibroUpdate", request);
			break;

		case "LIBROLIST":
			List<LibroDTO> libroDTOList = libroService.getAll();
			// Impacchetta la request con la lista dei libri
			request.put("libri", libroDTOList);
			MainDispatcher.getInstance().callView("Libro", request);
			break;

		// Esegue uno switch sulla base del comando inserito dall'utente e reindirizza
		// tramite il Dispatcher alla View specifica per ogni operazione
		// con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":

			// toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {

			case "L":
				MainDispatcher.getInstance().callView(sub_package + "LibroRead", null);
				break;

			case "I":
				MainDispatcher.getInstance().callView(sub_package + "LibroInsert", null);
				break;

			case "M":
				MainDispatcher.getInstance().callView(sub_package + "LibroUpdate", null);
				break;

			case "C":
				MainDispatcher.getInstance().callView(sub_package + "<LibroDelete", null);
				break;

			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeUser", null);
				break;

			default:
				MainDispatcher.getInstance().callView("Login", null);
			}

		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
