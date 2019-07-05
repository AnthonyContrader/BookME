package it.contrader.controller;

import java.util.List;

import it.contrader.dto.StoryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.StoryService;

public class StoryController implements Controller{
	
	private static String sub_package = "story.";
	
	private StoryService storyService;
	
	public StoryController() {
		this.storyService = new StoryService() ; 
	}

	@Override
	public void doControl(Request request) {
		// TODO Auto-generated method stub
		String choice= (String) request.get("choice") ;
		if(choice== null) {
			choice = "default";

		} else {
			//choice = "GETCHOICE";
		}

		String mode = (String) request.get("mode") ;
		if(mode == null) {
			mode = "default";
		}
		//System.out.println("choice =  "+choice);
	    //System.out.println("mode =  "+mode);
		
		int id_storie;
		String trama ; 
		
		switch (mode) {
		
		default:
			List<StoryDTO> lista = storyService.getAll();
			request.put("lista", lista);
			MainDispatcher.getInstance().callView("Story", request);
			break;
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		
		case "READ":
			id_storie = (int) request.get("id_storia");
			StoryDTO storyDTO = storyService.read(id_storie);
			request.put("storyRead", storyDTO);
			MainDispatcher.getInstance().callView(sub_package + "StoryRead", request);
			break;
			
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			
			trama = request.get("trama").toString();
			
			//costruisce l'oggetto story da inserire
			StoryDTO storytoinsert = new StoryDTO(trama);
			//invoca il service
			storyService.insert(storytoinsert);
			Request.getInstance().put("mode", "mode");
			//Rimanda alla view con la risposta
			
			List<StoryDTO> l = storyService.getAll();
			request.put("lista", l);
			MainDispatcher.getInstance().callView("Story", request);
			
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id_storie = Integer.parseInt(request.get("id_Storie").toString());
			//Qui chiama il service
			storyService.delete(id_storie);
			Request.getInstance().put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "StoryDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id_storie = Integer.parseInt(request.get("id_Storie").toString());
			trama = request.get("trama").toString();
			StoryDTO storytoupdate = new StoryDTO(trama);
			storytoupdate.setId_story(id_storie);
			storyService.update(storytoupdate);
			Request.getInstance().put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "StoryUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "STORYLIST":
			List<StoryDTO> storiesDTO = storyService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("storie", storiesDTO);
			MainDispatcher.getInstance().callView("Story", request);
			break;
			
			
		 case "GETCHOICE":
						
						//toUpperCase() mette in maiuscolo la scelta
				switch (choice.toUpperCase()) {
				
				case "L":
					MainDispatcher.getInstance().callView(sub_package + "StoryRead", request);
					break;
					
				case "I":
					//System.out.println("chiamo la StoryInsertView");
					MainDispatcher.getInstance().callView(sub_package + "StoryInsert", request);
					break;
					
				case "M":
					MainDispatcher.getInstance().callView(sub_package + "StoryUpdate", request);
					break;
					
				case "C":
					MainDispatcher.getInstance().callView(sub_package + "StoryDelete", request);
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
				
			
			}	

		
	}

}
