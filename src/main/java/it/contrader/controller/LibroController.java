package it.contrader.controller;

import java.util.List;

import it.contrader.dto.LibroDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.LibroService;


public class LibroController implements Controller {

	/**
	 * definisce il pacchetto di vista user.
	 */
	private static String sub_package = "libro.";
	
	private LibroService userService;

	public LibroController() {
		this.LibroService = new LibroService();
	}
	
	
	
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		int id;
		String username;
		String password;
		String usertype;

		switch (mode) {
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			LibroDTO userDTO = libroService.read(id);
			request.put("libro", libroDTO);
			MainDispatcher.getInstance().callView(sub_package + "LibroRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			username = request.get("username").toString();
			password = request.get("password").toString();
			usertype = request.get("usertype").toString();
			
			//costruisce l'oggetto user da inserire
			LibroDTO librotoinsert = new LibroDTO(username, password, usertype);
			//invoca il service
			userService.insert(librotoinsert);
			Request.getInstance().put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "LibroInsert", request);
			break;
		
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			libroService.delete(id);
			Request.getInstance().put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "LibroDelete", request);
			break;
		
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			username = request.get("username").toString();
			password = request.get("password").toString();
			usertype = request.get("usertype").toString();
		    LibroDTO usertoupdate = new LibroDTO(username, password, usertype);
			librotoupdate.setId(id);
			libroService.update(librotoupdate);
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "LibroUpdate", request);
			break;
			
		case "LIBROLIST":
			List<LibroDTO> usersDTO = libroService.getAll();
			//Impacchetta la request con la lista dei libri
			request.put("libri", libroDTO);
			MainDispatcher.getInstance().callView("Libro", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
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
