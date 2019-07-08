
package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.LibroDTO;
import it.contrader.main.MainDispatcher;

public class LibroView extends AbstractView{

     private Request request; 
     private String choice ; 
     
     @SuppressWarnings("unchecked")
	@Override
	public void showResults(Request request) {
		
		this.request = request ; 
		
		System.out.println("----- .:LIBRO VIEW:. ------- \n");
		
		 
		List<LibroDTO> lista = (List<LibroDTO>) request.get("libri") ; 
		 
		 for(LibroDTO libro: lista) {
			 System.out.println("[" + libro.getId_Libro()+"] "+libro.getNome_Libro());
		 }
				 
	}
	

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		
		System.out.println("[0~9] Leggi libro, [T]orna al menù");
		choice = getInput() ; 
	}

	@Override
	public void submit() {
		if(choice.matches("\\d+")) {
			int libroId = Integer.parseInt(choice);
			request.put("idLibro", libroId);
			request.put("mode","READ");
			MainDispatcher.getInstance().callAction("Libro", "doControl", this.request);
		} else {
			
			MainDispatcher.getInstance().callAction("Home", "doControl", this.request);
		}
		
		
		
	}
	


}
