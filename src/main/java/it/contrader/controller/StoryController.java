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

	@SuppressWarnings("null")
	@Override
	public void doControl(Request request) {
		// TODO Auto-generated method stub
		String choice= (String) request.get("choice") ;
		if(choice== null) {
			choice = "default";

		} 

		String mode = (String) request.get("mode");
		if(mode == null) {
			mode = "default";
		}

		
		int id_storie;
		String trama ; 
		int id_Categoria;
		
		switch (mode) {
		
		default:
			List<StoryDTO> lista = storyService.getAll();
			request.put("lista", lista);
			MainDispatcher.getInstance().callView("Story", request);
			break;
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		
		case "READ":
			System.out.print("Sei nel read");
			id_storie = (int) request.get("id_storia");
			StoryDTO storyDTO = storyService.read(id_storie);
			request.put("storyRead", storyDTO);
			
			MainDispatcher.getInstance().callView(sub_package + "StoryRead", request);
			break;
			
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			
			
		    
		    //String check = (String) request.remove("check");
		    //if(check == "check")
		if(request.get("trama")!=null)    
		{
		    	id_Categoria = (int)request.get("categoryId");
			    trama = request.remove("trama").toString();
		    	
		    	System.out.print("DEBUG1");
		    	StoryDTO story = new StoryDTO(trama, id_Categoria);
		    	storyService.insert(story);
		    	MainDispatcher.getInstance().callView(sub_package + "Story", request);
		    	
		    }

		    
			
		
			MainDispatcher.getInstance().callView(sub_package + "StoryInsert", request);
		
			//id_Categoria = request.get("id_Categoria").to
			//costruisce l'oggetto story da inserire
			//
			//invoca il service
			//storyService.insert(storytoinsert);
			//Request.getInstance().put("mode", "mode");
			//Rimanda alla view con la risposta
			
			//List<StoryDTO> l = storyService.getAll();
			//request.put("lista", l);
			//MainDispatcher.getInstance().callView("StoryInsert", request);
			
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id_storie = Integer.parseInt(request.get("id_storia").toString());
			//Qui chiama il service
			storyService.delete(id_storie);
			Request.getInstance().put("mode", "mode");
			
			List<StoryDTO> l2 = storyService.getAll();
			request.put("lista", l2);
			MainDispatcher.getInstance().callView("Story", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id_storie = Integer.parseInt(request.get("id_storia").toString());
			trama = request.getString("trama").toString();
			int idCategorie = (int)request.get("idCategoria");
			StoryDTO story = new StoryDTO(id_storie,trama,idCategorie);
			storyService.update(story);
			Request.getInstance().put("mode", "mode");

			List<StoryDTO> l3 = storyService.getAll();
			request.put("lista", l3);
			MainDispatcher.getInstance().callView("Story", request);
			
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
					
				case "T":
					MainDispatcher.getInstance().callView("HomeUser",request);
					break ;  
					
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
