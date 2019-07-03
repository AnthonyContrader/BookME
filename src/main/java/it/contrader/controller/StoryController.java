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
		
		String choice = (String) request.get("choice") ;
		String mode = (String) request.get("mode") ;
		
		System.out.println("mode =  "+mode);
		//System.out.println("choice =  "+choice);
		
		int id_story;
		String trama ; 
		
		switch (mode) {
		
		default:
			MainDispatcher.getInstance().callView("Story", request);
			break;
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			id_story = Integer.parseInt(request.get("id_Storie").toString());
			StoryDTO storyDTO = storyService.read(id_story);
			request.put("story", storyDTO);
			MainDispatcher.getInstance().callView(sub_package + "StoryRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			
			trama = request.get("trama").toString();
			System.out.println("trama = "+trama);
			
			//costruisce l'oggetto user da inserire
			StoryDTO storytoinsert = new StoryDTO(trama);
			//invoca il service
			storyService.insert(storytoinsert);
			request = new Request();
			request.put("mode", "");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView("Story", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id_story = Integer.parseInt(request.get("id_Storie").toString());
			//Qui chiama il service
			storyService.delete(id_story);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "StoryDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id_story = Integer.parseInt(request.get("id_Storie").toString());
			trama = request.get("trama").toString();
			StoryDTO storytoupdate = new StoryDTO(trama);
			storytoupdate.setId_story(id_story);
			storyService.update(storytoupdate);
			request = new Request();
			request.put("mode", "mode");
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
					MainDispatcher.getInstance().callView(sub_package + "StoryRead", null);
					break;
					
				case "I":
					//System.out.println("chiamo la StoryInsertView");
					MainDispatcher.getInstance().callView(sub_package + "StoryInsert", null);
					break;
					
				case "M":
					MainDispatcher.getInstance().callView(sub_package + "StoryUpdate", null);
					break;
					
				case "C":
					MainDispatcher.getInstance().callView(sub_package + "StoryDelete", null);
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
