package it.contrader.controller;

import java.util.List;

import it.contrader.dto.PersonaggiDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.PersonaggiService;


public class PersonaggiController implements Controller {


	private static String sub_package = "Personaggi.";
	
	private PersonaggiService PersonaggiService;

	public PersonaggiController() {
		this.PersonaggiService = new PersonaggiService();
	}
	
	
	

	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		int id_personaggio = 0;
		String nota;


		switch (mode) {
		
		case "READ":
			id_personaggio = Integer.parseInt(request.get("id_personaggio").toString());
			PersonaggiDTO PersonaggiDTO = PersonaggiService.read(id_personaggio);
			request.put("Personaggi", PersonaggiDTO);
			MainDispatcher.getInstance().callView(sub_package + "PersonaggiRead", request);
			break;
		
		case "INSERT":
			nota = request.get("Personagginame").toString();

			
			PersonaggiDTO Personaggitoinsert = new PersonaggiDTO(id_personaggio, nota);
			PersonaggiService.insert(Personaggitoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PersonaggiInsert", request);
			break;
		
		case "DELETE":
			id_personaggio = Integer.parseInt(request.get("id_personaggio").toString());
			PersonaggiService.delete(id_personaggio);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PersonaggiDelete", request);
			break;
		
		case "UPDATE":
			id_personaggio = Integer.parseInt(request.get("id_personaggio").toString());
			nota = request.get("Personagginame").toString();

			PersonaggiDTO Personaggitoupdate = new PersonaggiDTO(id_personaggio, nota);
			Personaggitoupdate.setId_Personaggio(id_personaggio);
			PersonaggiService.update(Personaggitoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PersonaggiUpdate", request);
			break;
			
		case "PersonaggiLIST":
			List<PersonaggiDTO> PersonaggisDTO = PersonaggiService.getAll();
			request.put("Personaggis", PersonaggisDTO);
			MainDispatcher.getInstance().callView("Personaggi", request);
			break;
			

		case "GETCHOICE":
					
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "PersonaggiRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "PersonaggiInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "PersonaggiUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "PersonaggiDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
