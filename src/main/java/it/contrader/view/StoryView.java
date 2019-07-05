/*
 * DEDOU AHUA MAXIMIN */

package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.StoryDTO;
import it.contrader.main.MainDispatcher;

public class StoryView extends AbstractView{

     private Request request; 
     private String choice ; 
	
	@Override
	public void showResults(Request request) {
		
		this.request = request ; 
		
		System.out.println("----- .:STORIA VIEW:. ------- ");
		
		 List<StoryDTO> lista = (List<StoryDTO>) request.get("lista") ; 
		 
		 for(StoryDTO story: lista) {
			 System.out.println(story.getId_story()+" "+story.getTrama());
		 }
				 
		/**
		 * prendi la lista che è contenuta nella  richiesta
		 * ciclo foreach per ogni elemento lista 
		 * stampi elemento
		 */
		// TODO Auto-generated method stub
	}
	

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		
		System.out.print(" [I]nserisci , [C]ancella , [M]odifica , [L]eggi :  ");
		choice = getInput() ; 
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		//System.out.println("hai scelto l'opzione : "+choice);  
		request.put("choice",choice);
		request.put("mode","GETCHOICE");
		MainDispatcher.getInstance().callAction("Story", "doControl", this.request);
		
	}
	
	public static void main(String[] args) {
		
		//StoryView sv = new StoryView() ; 
		//sv.showOptions(); 
	}


}
